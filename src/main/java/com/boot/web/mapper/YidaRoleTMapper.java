package com.boot.web.mapper;

import com.boot.web.module.pojo.YidaRoleT;

import java.util.List;

public interface YidaRoleTMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(YidaRoleT record);

    int insertSelective(YidaRoleT record);

    YidaRoleT selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(YidaRoleT record);

    int updateByPrimaryKey(YidaRoleT record);

    /**
     * 根据用户id获取这个用户有哪些角色
     * @param userId
     * @return
     */
    List<YidaRoleT> getRoleListByUserId(String userId);


}