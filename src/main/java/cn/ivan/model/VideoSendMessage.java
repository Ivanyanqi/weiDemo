package cn.ivan.model;

/**
 * 视频回复model
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 17:43
 */
public class VideoSendMessage extends BaseSendMessage {

    private String mediaId;

    private String title;

    private String description;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
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

    @Override
    public String toString() {
        String baseResult = super.toString();
        return baseResult + "VideoSendMessage{" +
                "mediaId='" + mediaId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
