package com.spring.boot.springbootdemo.utils;

import com.spring.boot.springbootdemo.dto.responseDto.LoginResponseDto;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: Yi xiaobai
 * @Date: 2018/10/8 0008 上午 10:34
 * 权限操作工具类
 */
public class AuthUtils {

    public static Boolean getAuth(String authName, HttpSession session){
        LoginResponseDto responseDto = (LoginResponseDto)session.getAttribute("user");
        Map<String, Boolean> rightMap = responseDto.getOperRightMap();
        if (rightMap == null)
            return Boolean.FALSE;
        return rightMap.get(authName)!=null;
    }

    public static Boolean isLoginUser(HttpSession session){
        Object o = session.getAttribute("user");
        LoginResponseDto responseDto = (LoginResponseDto)session.getAttribute("user");
        return responseDto != null;
    }

    public static LoginResponseDto getUserBySession(HttpSession session){
        LoginResponseDto responseDto = (LoginResponseDto)session.getAttribute("user");
        return responseDto;
    }

    public static int getUserIdBySession(HttpSession session){
        LoginResponseDto responseDto = getUserBySession(session);
        if (responseDto == null)
            return 0;
        return responseDto.getId();
    }

    public static String getUserCodeBySession(HttpSession session){
        LoginResponseDto responseDto = getUserBySession(session);
        if (responseDto == null)
            return null;
        return responseDto.getLoginID();
    }

}
