package cn.ivan.model;

/**
 * 音乐回复模板
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 17:47
 */
public class MusicSendMessage extends BaseSendMessage{
    private String title;
    private String description;
    private String musicURL;
    private String hQMusicUrl;
    private String thumbMediaId;

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

    public String getMusicURL() {
        return musicURL;
    }

    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }

    public String gethQMusicUrl() {
        return hQMusicUrl;
    }

    public void sethQMusicUrl(String hQMusicUrl) {
        this.hQMusicUrl = hQMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String toString() {
        String baseResult = super.toString();
        return baseResult + "MusicSendMessage{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", musicURL='" + musicURL + '\'' +
                ", hQMusicUrl='" + hQMusicUrl + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                '}';
    }
}
