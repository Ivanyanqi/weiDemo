package cn.ivan.service.impl;

import cn.ivan.mapper.base.TAccessTokenMapper;
import cn.ivan.mapper.base.TMediaMapper;
import cn.ivan.model.ErrorMessage;
import cn.ivan.model.base.TAccessToken;
import cn.ivan.model.base.TMedia;
import cn.ivan.service.MediaService;
import cn.ivan.utils.HttpRequestUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/15
 * Time: 17:08
 */
@Service
public class MediaServiceImpl implements MediaService {

    private Logger logger  = LoggerFactory.getLogger(MediaServiceImpl.class);

    @Autowired
    private TMediaMapper tMediaMapper;

    @Autowired
    private TAccessTokenMapper tAccessTokenMapper;


    @Override
    public PageInfo<TMedia> selectByPage(int currentPage, int pageSize) {
        //开启分页
        PageHelper.startPage(currentPage,pageSize);
        List<TMedia> mediaList = tMediaMapper.select();
        PageInfo<TMedia> pageInfo = new PageInfo<>(mediaList);
        return pageInfo;
    }

    @Override
    public String uploadMedia(String type, String filePath) {
        //获取access_token
        TAccessToken tAccessToken = tAccessTokenMapper.selectAccessToken();
        if(tAccessToken != null){
            StringBuilder url = new StringBuilder("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=");
            url.append(tAccessToken.getAccess_token());
            url.append("&type=");
            url.append(type);
            File file = new File(filePath);
            String result = HttpRequestUtil.postFile(file, "media", url.toString());
            if(result.contains("media_id")){
                JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
                String  rType = (String) jsonObject.get("type");
                String media_id = (String) jsonObject.get("media_id");
                String thumb_media_id = null;
                if(media_id == null){
                    thumb_media_id = (String) jsonObject.get("thumb_media_id");
                }
                TMedia media = new TMedia();
                media.setMediaId(media_id);
                media.setThumbMediaId(thumb_media_id);
                media.setType(rType);
                tMediaMapper.insert(media);
                return "success";
            }else {
                ErrorMessage errorMessage = JSONObject.parseObject(result, ErrorMessage.class);
                logger.info(errorMessage.toString());
                return "微信接口调用出错 :" + result;
            }
        }else {
            logger.info("token 失效");
            return "没有可用的token";
        }
    }
}
