/**
 * Copyright (C), 2015-2019
 * FileName: IRoleService
 * Project Name:springboot-web
 * Date:     2019/5/22 10:39
 * Description:
 */
package com.boot.web.module.role.service;

import com.boot.web.module.entity.SysMenu;
import com.boot.web.module.entity.SysRole;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author mashuai
 * @version 2019/5/22
 * @since JDK1.7
 */
public interface IRoleService {

    List<SysRole> getRoleByUserId(Integer userId);
    List<SysMenu> getPermissionsByRoleId(Integer roleId);

}