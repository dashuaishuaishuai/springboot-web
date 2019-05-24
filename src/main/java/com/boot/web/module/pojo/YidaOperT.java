package com.boot.web.module.pojo;

public class YidaOperT {
    private String operId;

    private String operCode;

    private String operName;

    private String prefixUrl;

    private String poperId;

    private String menuId;

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode == null ? null : operCode.trim();
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public String getPrefixUrl() {
        return prefixUrl;
    }

    public void setPrefixUrl(String prefixUrl) {
        this.prefixUrl = prefixUrl == null ? null : prefixUrl.trim();
    }

    public String getPoperId() {
        return poperId;
    }

    public void setPoperId(String poperId) {
        this.poperId = poperId == null ? null : poperId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}