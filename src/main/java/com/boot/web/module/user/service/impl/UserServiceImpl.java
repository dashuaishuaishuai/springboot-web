/**
 * Copyright (C), 2015-2019
 * FileName: UserServiceImpl
 * Project Name: springboot-web
 * Date:     2019/5/22 11:00
 * Description:
 */
package com.boot.web.module.user.service.impl;

import com.boot.web.mapper.SysUserMapper;
import com.boot.web.module.entity.SysUser;
import com.boot.web.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;


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
public class UserServiceImpl implements IUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser findByUsername(String username) {
        Example example = Example.builder(SysUser.class)
                .where(Sqls.custom().andEqualTo("username",username))
                .build();
        return userMapper.selectOneByExample(example);
    }
}