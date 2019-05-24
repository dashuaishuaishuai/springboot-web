/**
 * Copyright (C), 2015-2019
 * FileName: UserServiceImpl
 * Project Name: springboot-web
 * Date:     2019/5/22 11:00
 * Description:
 */
package com.boot.web.module.user.service.impl;

import com.boot.web.mapper.YidaUserTMapper;
import com.boot.web.module.pojo.YidaUserT;
import com.boot.web.module.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

    @Resource
    YidaUserTMapper yidaUserTMapper;

    @Override
    public YidaUserT getUserInfoByCount(String account) {
        return yidaUserTMapper.selectByPrimaryKey(account);
    }
}