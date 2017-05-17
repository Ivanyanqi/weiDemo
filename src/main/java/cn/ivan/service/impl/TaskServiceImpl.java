package cn.ivan.service.impl;

import cn.ivan.mapper.base.TAccessTokenMapper;
import cn.ivan.model.ErrorMessage;
import cn.ivan.model.base.TAccessToken;
import cn.ivan.service.TaskService;
import cn.ivan.utils.HttpRequestUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 23:30
 */
@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    private long time = 0;

    static final int TRY_TIMES = 3;

    private String appID ;

    private String appsecret ;

    @Autowired
    private TAccessTokenMapper accessTokenMapper;

    @Scheduled(cron = "0 0 0/2 * * ? ")
    @Override
    public void accessToken() {
        logger.info((System.currentTimeMillis() - time) + "");
        time = System.currentTimeMillis();
        logger.info("==============task start=============");

        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" +
                "&appid="+ appID +"&secret=" + appsecret;
        String result = HttpRequestUtil.httpRequestGet(url, null);
        if(result != null && result.contains("access_token")){
            TAccessToken accessToken = JSONObject.parseObject(result, TAccessToken.class);
            accessToken.setCreateTime(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
            accessToken.setIsExpires(true);
            //先将数据库的设置位无效
            int updateCount = accessTokenMapper.updateAll();
            logger.info("update count : " + updateCount);
            //插入新的
            int insert = accessTokenMapper.insert(accessToken);
            if(insert > 0){
                logger.info("Insert success");
            }
        }else {
            ErrorMessage errorMessage = JSONObject.parseObject(result, ErrorMessage.class);
            logger.info(errorMessage.toString());
        }
    }


    @Scheduled(cron = "0 0 0 * * ? ")
    @Override
    public void deleteExpireToken(){
        // 每天凌晨清楚过期的token
        int i = accessTokenMapper.deleteExpireToken();
        logger.info("delete success :" + i +" count");
    }
}
