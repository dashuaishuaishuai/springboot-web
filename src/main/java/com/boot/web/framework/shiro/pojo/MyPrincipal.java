/**
 * Copyright (C), 2015-2019
 * FileName: MyPrincipal
 * Project Name: springboot-web
 * Date:     2019/5/22 16:17
 * Description:
 */
package com.boot.web.framework.shiro.pojo;

import lombok.Data;
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
@Data
public class MyPrincipal implements Serializable, AuthCachePrincipal {


    private static final long serialVersionUID = 1L;

    private String account;

    private String password;

    private Integer id;

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}