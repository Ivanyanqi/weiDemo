package cn.ivan.model;

/**
 * 语音，图片回复model
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 17:41
 */
public class MediaSendMessage extends BaseSendMessage{

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        String baseResult = super.toString();
        return baseResult + "MediaSendMessage{" +
                "mediaId='" + mediaId + '\'' +
                '}';
    }
}
