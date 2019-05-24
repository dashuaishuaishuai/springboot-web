package com.boot.web.mapper;

import com.boot.web.module.pojo.YidaPrivilegeT;

import java.util.List;

public interface YidaPrivilegeTMapper {
    int deleteByPrimaryKey(String privilegeId);

    int insert(YidaPrivilegeT record);

    int insertSelective(YidaPrivilegeT record);

    YidaPrivilegeT selectByPrimaryKey(String privilegeId);

    int updateByPrimaryKeySelective(YidaPrivilegeT record);

    int updateByPrimaryKey(YidaPrivilegeT record);

    /**
     * 查询这个用户有哪些 权限
     * @param userId
     * @return
     */
    List<YidaPrivilegeT> getPrivilegeListByUserId(String userId);
}