package com.spring.boot.springbootdemo.dto;

import com.spring.boot.springbootdemo.model.UserRoleFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yi xiaobai
 * 用户菜单内容
 */
public class MenuTreeDto {

    /** 父目录菜单 */
    private String parentMenu;
    private String menuCode;
    /**
     * menuId 菜单ID
     */
    private String menuId;
    /**
     * menuLevel 菜单类别（一级菜单/二级菜单)
     */
    private int menuType;
    /**
     * menuId 菜单名称
     */
    private String menuTitle;
    /**
     * menuId 菜单链接
     */
    private String menuHref;
    /**
     * menuId 子菜单
     */
    private List<MenuTreeDto> menuChildren;

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuHref() {
        return menuHref;
    }

    public void setMenuHref(String menuHref) {
        this.menuHref = menuHref;
    }

    public List<MenuTreeDto> getMenuChildren() {
        return menuChildren;
    }

    public void setMenuChildren(List<MenuTreeDto> menuChildren) {
        this.menuChildren = menuChildren;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /** 初始化用户动态菜单 */
    public List<MenuTreeDto> initMenuTree(List<UserRoleFunction> list){
        List<MenuTreeDto> menuTreeDtoList = new ArrayList<>();
        //重新封装menuTree
        for (UserRoleFunction userModel: list){
            MenuTreeDto parentMenuDto = new MenuTreeDto();
            //判断是否菜单
            if (userModel.getFunType()==1){
                List<MenuTreeDto> childList = new ArrayList<>();
                for (UserRoleFunction childModel: list){
                    MenuTreeDto childMenuDto = new MenuTreeDto();
                    if (childModel.getFunType()==2 && childModel.getPid()==userModel.getFunctionID() ){
                        childMenuDto.setMenuChildren(null);
                        childMenuDto.setMenuCode(childModel.getFuncode());
                        childMenuDto.setMenuHref(childModel.getUrl());
                        childMenuDto.setMenuId(childModel.getLoginID().toString());
                        childMenuDto.setMenuTitle(childModel.getFunname());
                        childMenuDto.setMenuType(childModel.getFunType());
                        childList.add(childMenuDto);
                    }
                }
                parentMenuDto.setMenuChildren(childList);
                parentMenuDto.setMenuCode(userModel.getFuncode());
                parentMenuDto.setMenuHref(userModel.getUrl());
                parentMenuDto.setMenuId(userModel.getLoginID().toString());
                parentMenuDto.setMenuTitle(userModel.getFunname());
                parentMenuDto.setMenuType(userModel.getFunType());
                menuTreeDtoList.add(parentMenuDto);
            }
        }
        return menuTreeDtoList;
    }

    /** 初始化用户权限数据 */
    public Map<String, Boolean> initRightOpMap(List<UserRoleFunction> list){
        Map<String, Boolean> rightMap = new HashMap<>();
        for (UserRoleFunction userModel: list) {
            if (userModel.getFunType() == 1 ||userModel.getFunType() == 2 ) {
                rightMap.put(userModel.getFuncode(), Boolean.TRUE);
            }
        }
        return rightMap;
    }
}
