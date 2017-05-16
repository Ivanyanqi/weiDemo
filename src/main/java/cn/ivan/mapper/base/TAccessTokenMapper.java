package cn.ivan.mapper.base;

import cn.ivan.model.base.TAccessToken;

public interface TAccessTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TAccessToken record);

    int insertSelective(TAccessToken record);

    TAccessToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAccessToken record);

    int updateByPrimaryKey(TAccessToken record);

    int updateAll();

    int deleteExpireToken();

    TAccessToken selectAccessToken();
}