package cn.ivan.mapper.base;

import cn.ivan.model.base.TUser;

import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser selectByUserName(String userName);

    TUser selectByUser(TUser user);

    List<TUser> select();
}