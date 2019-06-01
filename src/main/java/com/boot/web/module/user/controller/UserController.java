/**
 * Copyright (C), 2015-2019
 * FileName: UserController
 * Project Name: springboot-web
 * Date:     2019/5/21 17:04
 * Description:
 */
package com.boot.web.module.user.controller;

import com.boot.web.module.user.pojo.Msg;
import com.boot.web.module.user.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author mashuai
 * @version 2019/5/21
 * @since JDK1.7
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService userService;
    @GetMapping("/list")
    public String getAllUser(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", "额外信息，只对管理员显示");
        userService.findByUsername("admin");
        return "index";
    }
}