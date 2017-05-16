package cn.ivan.utils;


import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/1/22
 * Time: 14:13
 */
public class FreeMarkerUtil {

    //创建FreeMarker的Configuration ，整个应用中只有一个实例
    private Configuration configuration = new Configuration();
    public  String createHTML(){
        try {
            // 设置模板路径
            configuration.setClassForTemplateLoading(this.getClass(),"/cn/ivan/ftl");

            //绝对路径方式加载模板，可以
            //configuration.setDirectoryForTemplateLoading(new File("D:\\workspace\\idea\\freemarker\\freemarkerDemo\\src\\main\\java\\cn\\ivan\\ftl"));

            //web应用方式加载，可以
            //configuration.setServletContextForTemplateLoading(context,"/WEB-INF/ftl");
            // 设置默认编码
            configuration.setDefaultEncoding("utf-8");
            // 获取模板
            Template template = configuration.getTemplate("demo.ftl");
            //设置模板数据
            Map<String,String> map = new HashMap<>();
            map.put("title","生成的第一个FreeMarker模板");
            //设置输出文件
            File file = new File ("d:/freemarker/demo.html");
            //获取输出
            FileWriter out = new FileWriter(file);
            // 输出html页面
            template.process(map,out);
            System.out.println("生成HTML页面!");
            out.close();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    public static void main(String[] args){
        new FreeMarkerUtil().createHTML();
    }
}
