/**
 * Copyright (C), 2015-2019
 * FileName: MyPrincipal
 * Project Name: springboot-web
 * Date:     2019/5/22 16:17
 * Description:
 */
package com.boot.web.framework.shiro.pojo;

import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author mashuai
 * @version 2019/5/22
 * @since JDK1.7
 */
public class MyPrincipal implements Serializable, AuthCachePrincipal {


    private static final long serialVersionUID = 1L;

    private String account;

    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}