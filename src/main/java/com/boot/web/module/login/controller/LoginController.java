/**
 * Copyright (C), 2015-2019
 * FileName: LoginController
 * Project Name: springboot-web
 * Date:     2019/5/22 9:23
 * Description:
 */
package com.boot.web.module.login.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author mashuai
 * @version 2019/5/22
 * @since JDK1.7
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 跳转到登录页
     *
     * @return
     */
    @GetMapping({"/unauth", ""})
    public String login() {
        return "login";
    }

    //进入首页
    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/doLogin", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(Model model, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String passWord = request.getParameter("passWord");
        String loginNo = request.getParameter("loginNo");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginNo, passWord);
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
            model.addAttribute("token", subject.getSession().getId());
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("msg", jsonObject);
        return "index";
    }

    /**
     * 未登录，shiro应重定向到登录界面
     * 如果是前后端分离的需要返回
     *
     * @return
     */
    @RequestMapping(value = "/unauth")
    public String unauth() {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }

        return "login";
    }
}