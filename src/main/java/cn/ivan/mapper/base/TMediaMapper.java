package cn.ivan.mapper.base;

import cn.ivan.model.base.TMedia;

import java.util.List;

public interface TMediaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMedia record);

    int insertSelective(TMedia record);

    TMedia selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMedia record);

    int updateByPrimaryKeyWithBLOBs(TMedia record);

    int updateByPrimaryKey(TMedia record);

    List<TMedia> select();
}