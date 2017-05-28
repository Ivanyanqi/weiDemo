package cn.ivan.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Description :  websocket 建议 使用javaEE的标准, 使用tomcat的版本为7.0.47以上
 * Date : 2017/5/25
 * Time : 15:03
 *
 * @author : 仙人球
 */

 /*
    1. ServerEndPoint 注解是一个类层次的注解，功能主要是将当前的类注册成为一个webSocket服务端，
       注解的值将被用于监听用户连接的终端访问的URL地址
  */

@ServerEndpoint("/ws/test")
public class MyWebSocket {

    private Logger logger = LoggerFactory.getLogger(MyWebSocket.class);

    /**
     * 线程安全的set，存放每个客户端对应的webSocket session
     */
    private static CopyOnWriteArraySet<Session> set = new CopyOnWriteArraySet<>();

    /**
     *  新用户连接时调用的方法
     */
    @OnOpen
    public void onOpen(Session session){
        String id = session.getId();
        set.add(session);
        logger.info("connected..{}",id);
    }

    /**
     *  断开连接时所调用的方法
     */
    @OnClose
    public void onClose(Session session){
        String id = session.getId();
        set.remove(session);
        logger.info("closed..{}",id);
    }


    @OnError
    public void onError(Session session ,Throwable throwable){
        logger.error("Exception = {}",throwable.getMessage());
    }

    /**
     *   定义了服务器接收到客户端发送的消息时所调用的方法，必须的参数是string类型的message，
     *   可选参数session,代表当前客户端的连接session
     * @param message
     * @param session
     */
    @OnMessage
    public void message(String message, Session session) throws IOException {
        logger.info("客户端发送的消息:{}",message);
        for(Session s : set){
            s.getBasicRemote().sendText(message);
        }
    }

    public static CopyOnWriteArraySet<Session> getSet() {
        return set;
    }

}
