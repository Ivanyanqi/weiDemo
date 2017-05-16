package cn.ivan.service;

import cn.ivan.model.base.TMedia;
import com.github.pagehelper.PageInfo;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/15
 * Time: 17:08
 */
public interface MediaService {
    PageInfo<TMedia> selectByPage(int currentPage, int pageSize);

    String uploadMedia(String type,String filePath);
}
