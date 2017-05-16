package cn.ivan.controller;

import cn.ivan.annotation.LoginCheck;
import cn.ivan.model.*;
import cn.ivan.service.WeiChatService;
import cn.ivan.utils.WeiChatUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 14:49
 */
@Controller
public class WeiChatController {

    private Logger logger = LoggerFactory.getLogger(WeiChatController.class);

    @Value("${weiChat.token}")
    private String token;

    @Autowired
    private WeiChatService weiChatService;

    /**
     * 接口验证:
     * 流程：
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
     *
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @param out       输出流
     */
    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/weiInterface", method = RequestMethod.GET)
    public void checkSignature(String signature, String timestamp, String nonce, String echostr, PrintWriter out) {
        String[] str = {timestamp, nonce, token};
        System.out.print(Arrays.toString(str));
        //字典顺序排序
        Arrays.sort(str);
        // 拼接字符串
        StringBuilder sbs = new StringBuilder();
        for (String s : str) {
            sbs.append(s);
        }
        //进行sha1加密
        String sha1Hex = DigestUtils.sha1Hex(sbs.toString());
        logger.info(sha1Hex + "==" + signature);
        if (sha1Hex.equals(signature)) out.write(echostr);
    }

    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/weiInterface", method = RequestMethod.POST)
    public void message(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 设置请求响应编码
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            //设置响响应头 xml报文
            response.setContentType("text/xml");
            //获取输入流
            ServletInputStream inputStream = request.getInputStream();
            Message message = WeiChatUtil.xmlToMessage(inputStream);
            logger.info(message.toString());
            BaseSendMessage baseSendMessage = weiChatService.sendMessage(message);
            String result = null;
            if (baseSendMessage instanceof TextSendMessage) {
                TextSendMessage textSendMessage = (TextSendMessage) baseSendMessage;
                logger.info(textSendMessage.toString());
                result = WeiChatUtil.textToxml(textSendMessage);
            } else if (baseSendMessage instanceof MusicSendMessage) {
                MusicSendMessage musicSendMessage = (MusicSendMessage) baseSendMessage;
                logger.info(musicSendMessage.toString());
                result = WeiChatUtil.sendMusic(musicSendMessage);
            } else if (baseSendMessage instanceof NewsSendMessage) {
                NewsSendMessage newsSendMessage = (NewsSendMessage) baseSendMessage;
                result = WeiChatUtil.sendNews(newsSendMessage);
            }
            logger.info(result);
            response.getWriter().write(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
