package com.boot.web.framework.shiro.realm;

import com.boot.web.framework.shiro.pojo.MyPrincipal;
import com.boot.web.module.entity.SysMenu;
import com.boot.web.module.entity.SysRole;
import com.boot.web.module.entity.SysUser;
import com.boot.web.module.role.service.IRoleService;
import com.boot.web.module.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 华安  mashuai_bj@si-tech.com.cn
 * @Title:
 * @Date: Create in 20:10 2018/4/18
 * @Description:
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private IUserService userService;
    @Resource
    private IRoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String loginNo = (String) super.getAvailablePrincipal(principals);
        SysUser userInfo = userService.findByUsername(loginNo);
        List<String> roleCodes = new ArrayList<String>();
        List<String> permissionLists = new ArrayList<String>();
        if (loginNo != null) {
            log.info("The login username: " + loginNo);
            /**
             * 查询用户有哪些角色
             */
            List<SysRole> roles = roleService.getRoleByUserId(userInfo.getId());
            if (roles != null && roles.size() > 0) {
                roles.forEach(item -> {
                    roleCodes.add(item.getValue());
                    List<SysMenu> privilegeTS = roleService.getPermissionsByRoleId(item.getId());
                    if (privilegeTS != null && privilegeTS.size() > 0) {
                        privilegeTS.forEach(it -> permissionLists.add(item.getValue()));
                    }
                });
            }
        } else {
            log.info("The login username is null");
            throw new AuthorizationException();
        }
        info.addRoles(roleCodes);
        info.addStringPermissions(permissionLists);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        log.info("The login username is null");
        SysUser userInfo = userService.findByUsername(username);
        if (userInfo == null) {
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(true);
        session.removeAttribute("userInfo");
        session.setAttribute("userInfo", userInfo);
        MyPrincipal principal = new MyPrincipal();
        principal.setAccount(userInfo.getUsername());
        principal.setPassword(userInfo.getPassword());
        principal.setId(userInfo.getId());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal,
                userInfo.getPassword(), //密码
                username  //realm name
        );
        return authenticationInfo;
    }
}