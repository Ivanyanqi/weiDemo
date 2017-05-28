package cn.ivan.controller;

import cn.ivan.annotation.LoginCheck;
import cn.ivan.ws.MyWebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 16:32
 */
@Controller
public class TestController {

    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String getMethod() throws IOException, InterruptedException {
        CopyOnWriteArraySet<Session> set = MyWebSocket.getSet();
        for(Session s :set){
            s.getBasicRemote().sendText("hello world");
        }
        Thread.sleep(10000);
        for(Session s :set){
            s.getBasicRemote().sendText("hello world");
        }
        return "GET";
    }

    @LoginCheck(anonymity = true)
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public String postMethod(){
        return "POST";
    }
}
