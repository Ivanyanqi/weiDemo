package cn.ivan.service;

import cn.ivan.model.BaseSendMessage;
import cn.ivan.model.Message;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 16:51
 */
public interface WeiChatService {


    /**
     * 回复消息
     * @return
     */
    BaseSendMessage sendMessage(Message message);

}
