package cn.ivan.service.impl;

import cn.ivan.mapper.base.TUserMapper;
import cn.ivan.model.base.TUser;
import cn.ivan.service.UserService;
import cn.ivan.utils.EncryptUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 13:27
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public int register(TUser user) {
        if(user == null) return 0;
        String md5Encrypt = EncryptUtil.MD5Encrypt(user.getPassword());
        user.setPassword(md5Encrypt);
        return tUserMapper.insert(user);
    }

    @Override
    public int getUserName(String userName) {
        TUser tUser = tUserMapper.selectByUserName(userName);
        if(tUser == null) return 0;
        else return 1;
    }

    @Override
    public TUser getUser(TUser user) {
        if(user == null) return null;
        String md5Encrypt = EncryptUtil.MD5Encrypt(user.getPassword());
        user.setPassword(md5Encrypt);
        return tUserMapper.selectByUser(user);
    }

    @Override
    public PageInfo<TUser> userList(String currentPage) {
        int page = currentPage == null ? 1 : Integer.parseInt(currentPage);
        PageHelper.startPage(page, 10);
        List<TUser> userList = tUserMapper.select();
        PageInfo<TUser> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}
