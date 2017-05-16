package cn.ivan.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

/**
 * 模拟http请求,调用接口获取数据
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 21:57
 */
public class HttpRequestUtil {

    public static String httpRequestPost(String url,JSONObject json,String param){
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        try {
            //构造请求体，发送json数据
            if(json != null){
                StringEntity stringEntity = new StringEntity(json.toString());
                stringEntity.setContentEncoding("utf-8");
                stringEntity.setContentType("application/json");
                post.setEntity(stringEntity);
            }else if(param != null){
                StringEntity stringEntity = new StringEntity(param);
                stringEntity.setContentEncoding("utf-8");
                stringEntity.setContentType("application/x-www-form-urlencoded");
                post.setEntity(stringEntity);
            }
            //发送请求,获取响应
            CloseableHttpResponse httpResponse = httpclient.execute(post);
            if(HttpStatus.SC_OK == httpResponse.getStatusLine().getStatusCode()){
                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity, "utf-8");
                return result;
            }
            return "fail";
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String httpRequestGet(String url,JSONObject json){
        //创建http实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            if(HttpStatus.SC_OK == httpResponse.getStatusLine().getStatusCode()){
                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity, "utf-8");
                return result;
            }
            return "fail";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *
     * @param file 文件
     * @param name 文件表单名
     * @param url 请求地址
     * @return
     */
    public static String postFile(File file,String name,String url){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        //将文件转化为流对象
        try {
            FileBody fileBody = new FileBody(file);
            //浏览器兼容模式访问，否则就是指定编码，文件名也会乱码
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            HttpEntity httpEntity = multipartEntityBuilder.addPart(name, fileBody).build();
            //设置charset上传失败（微信接口）
//          HttpEntity httpEntity = multipartEntityBuilder.addPart(name, fileBody).setCharset(Charset.forName("UTF-8")).build();
            post.setEntity(httpEntity);
            CloseableHttpResponse response = client.execute(post);
            if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity, "utf-8");
                return result;
            }
            return "fail";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
