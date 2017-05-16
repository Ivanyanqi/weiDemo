package cn.ivan.model;

/**
 * 回复文本的model
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 17:37
 */
public class TextSendMessage extends BaseSendMessage {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        String baseResult = super.toString();
        return baseResult + "TextSendMessage{" +
                "content='" + content + '\'' +
                '}';
    }
}
