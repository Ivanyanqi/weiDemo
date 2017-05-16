package cn.ivan.service;

import cn.ivan.model.base.TUser;
import com.github.pagehelper.PageInfo;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 13:27
 */
public interface UserService {

    int register(TUser user);

    int getUserName(String userName);

    TUser getUser(TUser user);

    PageInfo<TUser> userList(String currentPage);
}
