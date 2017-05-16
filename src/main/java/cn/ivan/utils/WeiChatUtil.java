package cn.ivan.utils;

import cn.ivan.model.*;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 17:26
 */
public class WeiChatUtil {

    /**
     * 将xml消息报文转换位Message 对象
     *
     * @param is 输入流
     * @return message 实体
     */

    public static Message xmlToMessage(InputStream is) {
        SAXReader reader = new SAXReader();
        Message message = new Message();
        try {
            Document document = reader.read(is);
            Element root = document.getRootElement();
            String name = root.getName();
            if (StringUtils.isNotBlank(name) && name.equals("xml")) {
                List<Element> elements = root.elements();
                if (elements != null && elements.size() > 0) {
                    for (Element element : elements) {
                        String eName = element.getName();
                        String text = element.getText();
                        if (eName.equals("ToUserName")) message.setToUserName(text);
                        else if (eName.equals("FromUserName")) message.setFromUserName(text);
                        else if (eName.equals("CreateTime")) message.setCreateTime(text);
                        else if (eName.equals("MsgType")) message.setMsgType(text);
                        else if (eName.equals("Content")) message.setContent(text);
                        else if (eName.equals("MsgId")) message.setMsgId(text);
                        else if(eName.equals("PicUrl")) message.setPicUrl(text);
                        else if(eName.equals("MediaId")) message.setMsgId(text);
                        else if(eName.equals("Format")) message.setFormat(text);
                        else if(eName.equals("Recognition")) message.setRecognition(text);
                        else if(eName.equals("ThumbMediaId")) message.setThumbMediaId(text);
                        else if(eName.equals("Location_X")) message.setLocation_X(text);
                        else if(eName.equals("Location_Y")) message.setLocation_Y(text);
                        else if(eName.equals("Scale")) message.setScale(text);
                        else if(eName.equals("Label")) message.setLabel(text);
                        else if(eName.equals("Title")) message.setTitle(text);
                        else if(eName.equals("Description")) message.setDescription(text);
                        else if(eName.equals("Url")) message.setUrl(text);
                        else if(eName.equals("Event")) message.setEvent(text);
                        else if(eName.equals("EventKey")) message.setEventKey(text);
                        else if(eName.equals("Ticket")) message.setTicket(text);
                        else if(eName.equals("Latitude")) message.setLatitude(text);
                        else if(eName.equals("Longitude")) message.setLongitude(text);
                        else if(eName.equals("Precision")) message.setPrecision(text);
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            message.setContent("消息报文出cuo");
        }

        return message;
    }

    /**
     * 回复文字消息
     * @param textSendMessage 文字消息model
     * @return xml报文
     */
    public static String textToxml(TextSendMessage textSendMessage){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[");
        sb.append(textSendMessage.getToUserName());
        sb.append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[");
        sb.append(textSendMessage.getFromUserName());
        sb.append("]]></FromUserName>");
        sb.append("<CreateTime>");
        sb.append(System.currentTimeMillis());
        sb.append("</CreateTime>");
        sb.append("<MsgType><![CDATA[");
        sb.append(textSendMessage.getMsgType());
        sb.append("]]></MsgType>");
        sb.append("<Content><![CDATA[");
        sb.append(textSendMessage.getContent());
        sb.append("]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 回复音乐
     * @param musicSendMessage 音乐消息模板
     * @return xml报文
     */
    public static String sendMusic(MusicSendMessage musicSendMessage){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[");
        sb.append(musicSendMessage.getToUserName());
        sb.append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[");
        sb.append(musicSendMessage.getFromUserName());
        sb.append("]]></FromUserName>");
        sb.append("<CreateTime>");
        sb.append(System.currentTimeMillis());
        sb.append("</CreateTime>");
        sb.append("<MsgType><![CDATA[");
        sb.append(musicSendMessage.getMsgType());
        sb.append("]]></MsgType>");
        sb.append("<Music>");
        sb.append("<Title><![CDATA[");
        sb.append(musicSendMessage.getTitle());
        sb.append("]]></Title>");
        sb.append("<Description><![CDATA[");
        sb.append(musicSendMessage.getDescription());
        sb.append("]]></Description>");
        sb.append("<MusicUrl><![CDATA[");
        sb.append(musicSendMessage.getMusicURL());
        sb.append("]]></MusicUrl>");
        sb.append("<HQMusicUrl><![CDATA[");
        sb.append(musicSendMessage.gethQMusicUrl());
        sb.append("]]></HQMusicUrl>");
        sb.append("<ThumbMediaId><![CDATA[");
        sb.append(musicSendMessage.getThumbMediaId());
        sb.append("]]></ThumbMediaId>");
        sb.append("</Music>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     *  回复图文消息
     * @param newsSendMessage 图文消息model
     * @return xml报文
     */
    public static String sendNews(NewsSendMessage newsSendMessage){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[");
        sb.append(newsSendMessage.getToUserName());
        sb.append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[");
        sb.append(newsSendMessage.getFromUserName());
        sb.append("]]></FromUserName>");
        sb.append("<CreateTime>");
        sb.append(System.currentTimeMillis());
        sb.append("</CreateTime>");
        sb.append("<MsgType><![CDATA[");
        sb.append(newsSendMessage.getMsgType());
        sb.append("]]></MsgType>");
        sb.append("<ArticleCount>");
        sb.append(newsSendMessage.getArticleCount());
        sb.append("</ArticleCount>");
        sb.append("<Articles>");
        List<Article> articles = newsSendMessage.getArticles();
        if(articles != null && articles.size() > 0){
            for(Article article : articles){
                sb.append("<item>");
                sb.append("<Title><![CDATA[");
                sb.append(article.getTitle());
                sb.append("]]></Title>");
                sb.append("<Description><![CDATA[");
                sb.append(article.getDescription());
                sb.append("]]></Description>");
                sb.append("<PicUrl><![CDATA[");
                sb.append(article.getPicUrl());
                sb.append("]]></PicUrl>");
                sb.append("<Url><![CDATA[");
                sb.append(article.getUrl());
                sb.append("]]></Url>");
                sb.append("</item>");
            }
        }
        sb.append("</Articles>");
        sb.append("</xml>");
        return sb.toString();

    }
}
