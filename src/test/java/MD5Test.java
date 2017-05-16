import cn.ivan.model.ErrorMessage;
import cn.ivan.model.base.TAccessToken;
import cn.ivan.model.base.TMedia;
import cn.ivan.utils.EncryptUtil;
import cn.ivan.utils.HttpRequestUtil;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 21:43
 */

public class MD5Test {

    @Test
    public void test1(){
        String md5Encrypt = EncryptUtil.MD5Encrypt("123");
        System.out.println(md5Encrypt);

    }

    @Test
    public void test2(){
        String url = "http://ws.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx/toTraditionalChinese?sText=闫琪";
        String result = HttpRequestUtil.httpRequestGet(url, null);
        System.out.println(result);
    }

    @Test
    public void test3(){
        String url = "http://ws.webxml.com.cn/WebServices/TraditionalSimplifiedWebService.asmx/toTraditionalChinese";
        // 表格内容编码
        String text ;
        try {
            text = URLEncoder.encode("闫琪","UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的编码格式",e);
        }

        String result = HttpRequestUtil.httpRequestPost(url, null,"sText="+ text);
        System.out.println(result);
    }

    /**
     * 获取access_token:getq请求
     */
    @Test
    public void test4(){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxbf11e53ee35d0b2f&secret=9b23d899663c09d5473f1bab5d551480";
        String result = HttpRequestUtil.httpRequestGet(url, null);
        TAccessToken accessToken = JSONObject.parseObject(result, TAccessToken.class);
        System.out.println(accessToken);
    }

    /**
     * 获取用户列表
     */
    @Test
    public void test5(){
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=px3qceIVwzht2VXHDcd6lNWRlopURiUQUD_J1pti4NkW5eDhz5bVngJXAWDXEax7hJYYzLcengMTCiLo2jOqorba61wB5WczdX62ggkG5lszaIqgoQa8qNe2_45fQbbMPIPaADAIBI&next_openid=";

        String result = HttpRequestUtil.httpRequestGet(url, null);

        System.out.println(result);

    }

    /**
     * 上传文件
     */
    @Test
    public void test6(){
        String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=Yjk_ZmpgywtVpOkCsMcMY4h1iJdDyLjjZQGhw1YYaVglnx9oXJ9fTKIVX0RWvFGS0GM9HfSglGN3nDom0pUnTCPIS6h1_kaRx7G68Q50-XSwsr00BdX0Yuotl--5BlcEIKThAAAWYH&type=image";
        File file = new File("D:\\timg3VJ58USG.jpg");
        String result = HttpRequestUtil.postFile(file,"media",url);
        if(result.contains("media_id")){
            JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
            String  type = (String) jsonObject.get("type");
            String media_id = (String) jsonObject.get("media_id");
            TMedia media = new TMedia();
            media.setMediaId(media_id);
            media.setType(type);
        }else{
            ErrorMessage errorMessage = JSONObject.parseObject(result, ErrorMessage.class);
            System.out.println(errorMessage);
        }
    }
}
