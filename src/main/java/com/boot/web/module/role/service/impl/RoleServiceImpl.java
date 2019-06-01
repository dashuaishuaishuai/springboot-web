/**
 * Copyright (C), 2015-2019
 * FileName: RoleServiceImpl
 * Project Name: springboot-web
 * Date:     2019/5/22 10:39
 * Description:
 */
package com.boot.web.module.role.service.impl;


import com.boot.web.mapper.SysMenuMapper;
import com.boot.web.mapper.SysRoleMapper;
import com.boot.web.module.entity.SysMenu;
import com.boot.web.module.entity.SysRole;
import com.boot.web.module.role.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public List<SysRole> getRoleByUserId(Integer userId) {
        return roleMapper.getRoleByUserId(userId);
    }

    @Override
    public List<SysMenu> getPermissionsByRoleId(Integer roleId) {
        return menuMapper.getPermissionsByRoleId(roleId);
    }

}