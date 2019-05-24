package com.boot.web.mapper;

import com.boot.web.module.pojo.YidaMenuT;

public interface YidaMenuTMapper {
    int deleteByPrimaryKey(String menuId);

    int insert(YidaMenuT record);

    int insertSelective(YidaMenuT record);

    YidaMenuT selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(YidaMenuT record);

    int updateByPrimaryKey(YidaMenuT record);
}