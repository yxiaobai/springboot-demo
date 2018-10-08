package com.spring.boot.springbootdemo.dto.responseDto;

import com.spring.boot.springbootdemo.dto.MenuTreeDto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用户登录后的返回实体
 */
public class LoginResponseDto implements Serializable{

    private int id;
    private String loginID;
    private String lastName;
    private String workCode;
    /** 用户关联的权限菜单树 */
    private List<MenuTreeDto> menuTreeDtoList;
    /** 用户关联的页签或按钮操作权限 */
    private Map<String, Boolean> operRightMap ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public List<MenuTreeDto> getMenuTreeDtoList() {
        return menuTreeDtoList;
    }

    public void setMenuTreeDtoList(List<MenuTreeDto> menuTreeDtoList) {
        this.menuTreeDtoList = menuTreeDtoList;
    }

    public Map<String, Boolean> getOperRightMap() {
        return operRightMap;
    }

    public void setOperRightMap(Map<String, Boolean> operRightMap) {
        this.operRightMap = operRightMap;
    }
}
