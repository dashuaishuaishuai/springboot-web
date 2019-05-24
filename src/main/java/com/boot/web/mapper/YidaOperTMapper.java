package com.boot.web.mapper;

import com.boot.web.module.pojo.YidaOperT;

import java.util.List;

public interface YidaOperTMapper {
    int deleteByPrimaryKey(String operId);

    int insert(YidaOperT record);

    int insertSelective(YidaOperT record);

    YidaOperT selectByPrimaryKey(String operId);

    int updateByPrimaryKeySelective(YidaOperT record);

    int updateByPrimaryKey(YidaOperT record);

    /**
     *
     * @param userId
     * @return
     */
    List<YidaOperT> getOperListByUserId(String userId);
}