/**
 * Copyright (C), 2015-2019
 * FileName: RoleServiceImpl
 * Project Name: springboot-web
 * Date:     2019/5/22 10:39
 * Description:
 */
package com.boot.web.module.role.service.impl;

import com.boot.web.mapper.YidaPrivilegeTMapper;
import com.boot.web.mapper.YidaRoleTMapper;
import com.boot.web.module.pojo.YidaPrivilegeT;
import com.boot.web.module.pojo.YidaRoleT;
import com.boot.web.module.role.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author mashuai
 * @version 2019/5/22
 * @since JDK1.7
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Resource
    YidaRoleTMapper yidaRoleTMapper;
    @Resource
    YidaPrivilegeTMapper yidaPrivilegeTMapper;

    @Override
    public List<YidaPrivilegeT> getPrivilegeListByUserId(String userId) {
        return yidaPrivilegeTMapper.getPrivilegeListByUserId(userId);
    }

    @Override
    public List<YidaRoleT> getRoleListByUserId(String userId) {
        return yidaRoleTMapper.getRoleListByUserId(userId);
    }
}