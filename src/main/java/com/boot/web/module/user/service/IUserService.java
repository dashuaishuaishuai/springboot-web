/**
 * Copyright (C), 2015-2019
 * FileName: IUserService
 * Project Name:springboot-web
 * Date:     2019/5/22 11:00
 * Description:
 */
package com.boot.web.module.user.service;

import com.boot.web.module.entity.SysUser;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author mashuai
 * @version 2019/5/22
 * @since JDK1.7
 */
public interface IUserService {
    SysUser findByUsername(String username);}