package cn.ivan.model;

import java.io.Serializable;

/**
 * 微信消息实体
 *     包括：文本消息、图片消息、语音消息、视频消息、小视频消息、地理位置消息、链接消息
 *
 *
 * User: 仙人球
 * Date: 2017/5/11
 * Time: 15:23
 */
public class Message implements Serializable{

    private static final long serialVersionUID = -6244693977256970524L;
    private String toUserName ; //  开发者微信号

    private String fromUserName; // 发送者账号（一个openid）

    private String createTime ; // 消息创建时间

    private String msgType ; // 消息类型

    private String Content; // 文本内容

    private String msgId;  // 消息id,64位整型

    private String picUrl;  // 图片链接

    private String mediaId; // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据

    private String format; // 语音格式

    private String recognition; //语音识别结果，UTF8编码

    private String thumbMediaId; //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。

    private String location_X;  //地理位置维度

    private String location_Y; //地理位置经度

    private String scale; //地图缩放大小

    private String label; //地理位置信息

    private String title ; //消息标题

    private String description; //消息描述

    private String url; //消息链接

    private String event; // 事件类型 subscribe(订阅)、unsubscribe(取消订阅)

    private String eventKey ; //事件KEY值，与自定义菜单接口中KEY值对应

    private String ticket; // 二维码的ticket，可用来换取二维码图片

    private String latitude ;//地理位置纬度

    private String longitude;//地理位置经度

    private String precision; //地理位置精度

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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getLocation_X() {
        return location_X;
    }

    public void setLocation_X(String location_X) {
        this.location_X = location_X;
    }

    public String getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(String location_Y) {
        this.location_Y = location_Y;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return "Message{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                ", Content='" + Content + '\'' +
                ", msgId='" + msgId + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", format='" + format + '\'' +
                ", recognition='" + recognition + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", location_X='" + location_X + '\'' +
                ", location_Y='" + location_Y + '\'' +
                ", scale='" + scale + '\'' +
                ", label='" + label + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", event='" + event + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", ticket='" + ticket + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", precision='" + precision + '\'' +
                '}';
    }
}
