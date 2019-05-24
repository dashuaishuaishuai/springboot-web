package com.boot.web.module.pojo;

public class YidaMenuT {
    private String menuId;

    private String menuName;

    private String menuUrl;

    private String menuPid;

    private Integer menuHeading;

    private String menuTranslate;

    private String menuParams;

    private String menuAlert;

    private String menuLabel;

    private String menuIcon;

    private Long menuSort;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid == null ? null : menuPid.trim();
    }

    public Integer getMenuHeading() {
        return menuHeading;
    }

    public void setMenuHeading(Integer menuHeading) {
        this.menuHeading = menuHeading;
    }

    public String getMenuTranslate() {
        return menuTranslate;
    }

    public void setMenuTranslate(String menuTranslate) {
        this.menuTranslate = menuTranslate == null ? null : menuTranslate.trim();
    }

    public String getMenuParams() {
        return menuParams;
    }

    public void setMenuParams(String menuParams) {
        this.menuParams = menuParams == null ? null : menuParams.trim();
    }

    public String getMenuAlert() {
        return menuAlert;
    }

    public void setMenuAlert(String menuAlert) {
        this.menuAlert = menuAlert == null ? null : menuAlert.trim();
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel == null ? null : menuLabel.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public Long getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Long menuSort) {
        this.menuSort = menuSort;
    }
}