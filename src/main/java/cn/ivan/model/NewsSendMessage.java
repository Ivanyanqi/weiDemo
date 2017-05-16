package cn.ivan.model;

import java.util.List;

/**
 * 图文消息回复model
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 17:50
 */
public class NewsSendMessage extends  BaseSendMessage{
    private String articleCount ;//图文消息个数，最多8个
    private List<Article> articles; //多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    @Override
    public String toString() {
        String baseResult = super.toString();
        return baseResult + "NewsSendMessage{" +
                "articleCount='" + articleCount + '\'' +
                ", articles=" + articles +
                '}';
    }
}
