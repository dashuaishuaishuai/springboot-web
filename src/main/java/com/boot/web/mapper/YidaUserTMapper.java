package com.boot.web.mapper;

import com.boot.web.module.pojo.YidaUserT;

public interface YidaUserTMapper {
    int deleteByPrimaryKey(String account);

    int insert(YidaUserT record);

    int insertSelective(YidaUserT record);

    YidaUserT selectByPrimaryKey(String account);

    int updateByPrimaryKeySelective(YidaUserT record);

    int updateByPrimaryKey(YidaUserT record);
}