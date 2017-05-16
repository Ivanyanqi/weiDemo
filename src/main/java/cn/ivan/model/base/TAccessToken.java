package cn.ivan.model.base;

public class TAccessToken {
    private Integer id;

    private String access_token;

    private String expires_in;

    private String createTime;

    private Boolean isExpires;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Boolean getIsExpires() {
        return isExpires;
    }

    public void setIsExpires(Boolean isExpires) {
        this.isExpires = isExpires;
    }

    @Override
    public String toString() {
        return "TAccessToken{" +
                "id=" + id +
                ", accessToken='" + access_token + '\'' +
                ", expiresIn='" + expires_in + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isExpires=" + isExpires +
                '}';
    }
}