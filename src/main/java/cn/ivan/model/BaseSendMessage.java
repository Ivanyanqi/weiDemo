package cn.ivan.model;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 17:33
 */
public class BaseSendMessage implements Serializable{
    private static final long serialVersionUID = -8687560943213814425L;

    private String toUserName ; //  用户微信号，对应接收消息的FromUserName

    private String fromUserName; // 开发者账号，对应接收消息的toUserName,

    private String createTime ; // 消息创建时间

    private String msgType ; // 消息类型

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return "BaseSendMessage{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
