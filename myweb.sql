/*
Navicat MySQL Data Transfer

Source Server         : 本电脑
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2019-05-24 15:57:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for yida_menupriv_r
-- ----------------------------
DROP TABLE IF EXISTS `yida_menupriv_r`;
CREATE TABLE `yida_menupriv_r` (
  `ID` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  `PRIVILEGE_ID` varchar(32) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for yida_menu_t
-- ----------------------------
DROP TABLE IF EXISTS `yida_menu_t`;
CREATE TABLE `yida_menu_t` (
  `MENU_ID` varchar(32) NOT NULL COMMENT '菜单ID',
  `MENU_NAME` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(128) DEFAULT NULL COMMENT '菜单URL',
  `MENU_PID` varchar(32) DEFAULT NULL COMMENT '父菜单ID',
  `MENU_HEADING` int(1) DEFAULT NULL COMMENT '控制菜单是否只作为span标签显示，0:false 1:true',
  `MENU_TRANSLATE` varchar(128) DEFAULT NULL COMMENT '菜单对应国际化文件中的值',
  `MENU_PARAMS` varchar(128) DEFAULT NULL COMMENT '跳转url时传的参数',
  `MENU_ALERT` varchar(64) DEFAULT NULL COMMENT '菜单的小提示框内容',
  `MENU_LABEL` varchar(32) DEFAULT NULL COMMENT '菜单小提示框的样式',
  `MENU_ICON` varchar(32) DEFAULT NULL COMMENT '菜单的图标',
  `MENU_SORT` bigint(11) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for yida_oper_t
-- ----------------------------
DROP TABLE IF EXISTS `yida_oper_t`;
CREATE TABLE `yida_oper_t` (
  `OPER_ID` varchar(32) NOT NULL COMMENT '操作ID',
  `OPER_CODE` varchar(32) NOT NULL COMMENT '操作编码',
  `OPER_NAME` varchar(64) NOT NULL COMMENT '操作名称',
  `PREFIX_URL` varchar(64) NOT NULL COMMENT '拦截URL前缀',
  `POPER_ID` varchar(32) NOT NULL COMMENT '父操作ID',
  `MENU_ID` varchar(32) DEFAULT NULL COMMENT '所属菜单ID',
  PRIMARY KEY (`OPER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for yida_privilege_t
-- ----------------------------
DROP TABLE IF EXISTS `yida_privilege_t`;
CREATE TABLE `yida_privilege_t` (
  `PRIVILEGE_ID` varchar(32) NOT NULL COMMENT '权限ID',
  `PRIVILEGE_TYPE` char(1) NOT NULL COMMENT '权限类型',
  `PRIVILEGE_NAME` varchar(64) DEFAULT '',
  `DESCRIPTION` varchar(256) DEFAULT '',
  `PRIVILEGE_STATUS` varchar(4) DEFAULT '',
  `CREATER` varchar(32) DEFAULT '',
  `CREATE_TIME` datetime DEFAULT NULL,
  `LAST_MODIFIER` varchar(32) DEFAULT '',
  `LAST_MODIFY_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`PRIVILEGE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for yida_privioper_r
-- ----------------------------
DROP TABLE IF EXISTS `yida_privioper_r`;
CREATE TABLE `yida_privioper_r` (
  `PRIVILEGE_ID` varchar(32) DEFAULT NULL COMMENT '权限ID',
  `OPER_ID` varchar(32) DEFAULT NULL COMMENT '操作ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for yida_roleprivilege_r
-- ----------------------------
DROP TABLE IF EXISTS `yida_roleprivilege_r`;
CREATE TABLE `yida_roleprivilege_r` (
  `ROLE_ID` varchar(32) DEFAULT NULL,
  `PRIVILEGE_ID` varchar(32) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for yida_role_t
-- ----------------------------
DROP TABLE IF EXISTS `yida_role_t`;
CREATE TABLE `yida_role_t` (
  `ROLE_ID` varchar(32) NOT NULL,
  `ROLE_NAME` varchar(64) NOT NULL,
  `ROLE_DESCRIPTION` varchar(128) DEFAULT NULL,
  `ROLE_STATUS` varchar(4) DEFAULT NULL,
  `CREATER` varchar(32) NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `LAST_MODIFIER` varchar(32) NOT NULL COMMENT '最后一次修改人',
  `LAST_MODIFY_TIME` datetime NOT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for yida_userrole_r
-- ----------------------------
DROP TABLE IF EXISTS `yida_userrole_r`;
CREATE TABLE `yida_userrole_r` (
  `ACCOUNT` varchar(32) DEFAULT NULL,
  `ROLE_ID` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for yida_user_t
-- ----------------------------
DROP TABLE IF EXISTS `yida_user_t`;
CREATE TABLE `yida_user_t` (
  `ACCOUNT` varchar(32) NOT NULL COMMENT '用户账号',
  `PASSWORD` varchar(32) NOT NULL COMMENT '用户密码',
  `REAL_NAME` varchar(64) DEFAULT NULL COMMENT '真实姓名',
  `NICK_NAME` varchar(64) DEFAULT NULL COMMENT '昵称',
  `IMG_PATH` varchar(0) DEFAULT NULL COMMENT '头像',
  `PHONE` varchar(32) DEFAULT NULL COMMENT '电话',
  `EMAIL` varchar(64) DEFAULT NULL COMMENT '邮件',
  `STATUS` varchar(1) DEFAULT NULL COMMENT '状态',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFIER` varchar(32) DEFAULT NULL COMMENT '最后一次修改人',
  `LAST_MODIFY_TIME` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  PRIMARY KEY (`ACCOUNT`) USING BTREE,
  UNIQUE KEY `NICK_NAME_U` (`NICK_NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
