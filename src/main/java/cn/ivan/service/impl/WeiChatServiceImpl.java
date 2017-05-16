package cn.ivan.service.impl;

import cn.ivan.model.*;
import cn.ivan.service.WeiChatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 16:52
 */
@Service
public class WeiChatServiceImpl implements WeiChatService {

    /**
     *
     * @param message 接收的消息
     * @return
     */
    @Override
    public BaseSendMessage sendMessage(Message message) {
        String msgType = message.getMsgType();
        String content = "不支持的类型==============哈哈哈哈";
        if(msgType != null){
            if(msgType.equals("text")){
                //content = "发送的文本消息";
                if(message.getContent() != null && message.getContent().equals("1")){
                    return sendNewsMessage(message);
                }
            }else if(msgType.equals("image")){
                content = "发送的图片消息";
            }else if(msgType.equals("voice")){
                content = "发送的语音消息";
            }else if(msgType.equals("video")){
                content = "发送的视频消息";
            }else if(msgType.equals("shortvideo")){
                content = "发送的小视频消息";
            }else if(msgType.equals("location")){
                content = "地理位置消息";
            }else if(msgType.equals("link")){
                content = "连接消息";
            }else if(msgType.equals("event")){
                //content = "事件消息";
                if(message.getEventKey().equals("V1001_TODAY_MUSIC")){
                    return sendMusicMessage(message);
                }else if(message.getEventKey().equals("V1001_GOOD")){
                    return sendTextMessage(message,"谢谢点赞！");
                }
            }
        }
        return sendTextMessage(message,content);
    }


    private TextSendMessage sendTextMessage(Message message,String content){
        TextSendMessage textSendMessage = new TextSendMessage();
        textSendMessage.setToUserName(message.getFromUserName());
        textSendMessage.setFromUserName(message.getToUserName());
        textSendMessage.setCreateTime(System.currentTimeMillis()+"");
        textSendMessage.setMsgType("text");
        textSendMessage.setContent(content);
        return textSendMessage;
    }

    private MusicSendMessage sendMusicMessage(Message message) {
        MusicSendMessage musicSendMessage = new MusicSendMessage();
        musicSendMessage.setToUserName(message.getFromUserName());
        musicSendMessage.setFromUserName(message.getToUserName());
        musicSendMessage.setCreateTime(System.currentTimeMillis()+"");
        musicSendMessage.setMsgType("music");
        musicSendMessage.setTitle("今日歌曲推荐");
        musicSendMessage.setDescription("不要对他说");
        musicSendMessage.setMusicURL("http://sc.111ttt.com/up/mp3/123645/78AB4962603BE81EFE387695A1F76819.mp3");
        musicSendMessage.setThumbMediaId("bMVb_27e6Ctq47U5f7YSY7lCpNCXlW7k_dlnTmA_qiUfJfknzXVmYgK0Tp9Wr5GH");
        return musicSendMessage;
    }

    private NewsSendMessage sendNewsMessage(Message message){
        NewsSendMessage newsSendMessage = new NewsSendMessage();
        newsSendMessage.setToUserName(message.getFromUserName());
        newsSendMessage.setFromUserName(message.getToUserName());
        newsSendMessage.setCreateTime(System.currentTimeMillis() + "");
        newsSendMessage.setMsgType("news");
        List<Article> articles = new ArrayList<>();
        Article article1 = new Article();
        article1.setTitle("射雕英雄传");
        article1.setDescription("该书主要讲述了郭靖背负着家恨国仇闯入江湖，在红颜知己黄蓉的帮助下通过无数历练，最终成长为“侠之大者”的民族英雄的武林故事");
        article1.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494759878542&di=d36f18a021c91f4bfb50784905d9201e&imgtype=0&src=http%3A%2F%2Fnews.chinaxiaokang.com%2Fuploads%2Fimage%2F20170404%2F1491299149514623.jpg");
        article1.setUrl("http://baike.baidu.com/link?url=N01essDBhgoiCJj_AUWsmH7u3VHfh45ZgJ9Ne2WxReY07YgRYh68G1-Wh9MjykwaaguSNOk50Xb9BnaF8TGJnkFk0yR-YcL-OqcQbOIRZCWDGb2TgnW8yXykGQ4OLPfxJQEEvA7EQvRcKXOuW_VtBK");
        articles.add(article1);
        Article article2 = new Article();
        article2.setTitle("神雕侠侣");
        article2.setDescription("该剧主要讲述了南宋末年，杨过和小龙女经历了一番凄美爱情与江湖恩怨的故事。一样的故事，不一样的情节，力求展现一个可歌可泣的江湖往事");
        article2.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494760175803&di=961b35d6524efe20f04df32ec25b059a&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2Fec932834349b033bacebee2e15ce36d3d439bd18.jpg");
        article2.setUrl("http://baike.baidu.com/link?url=qmaX9d1w1MOQ2oJPzzvgKHNZbpaCag4Ll6EubX7EHAesbOwXi45HgUwiceFAiBO0980wUJcjTqsah994EizX_MPSjc2cIJ2itnm6ILvuMdi5cw7KXQ_DF9t5RDVOx0-G");
        articles.add(article2);
        newsSendMessage.setArticleCount(2+"");
        newsSendMessage.setArticles(articles);
        return newsSendMessage;
    }
}
