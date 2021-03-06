package com.boot.web.mapper;

import com.boot.web.module.entity.SysMenu;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {
    @Select(value = "select menu.* from sys_menu menu,sys_privilege p where menu.id=p.menu_id and p.role_id=#{roleId}")
    List<SysMenu> getPermissionsByRoleId(Integer roleId);
}