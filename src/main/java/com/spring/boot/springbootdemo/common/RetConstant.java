package com.spring.boot.springbootdemo.common;

/**
 * @Author: Yi xiaobai
 * 接口返回值代码
 */
public class RetConstant {

    /**
     * 成功代码200
     */
    public static final int CODE_SUCCESS = 200;

    public static final String MSG_SUCCESS = "SUCCESS";

    public static final int CODE_UNLOGIN = 208;

    public static final String MSG_UNLOGIN = "用户未登录";

    /**
     * 参数错误
     */
    public static final int CODE_PARAM_ERR = 201;

    public static final String PARAM_USER_ERR = "用户名或密码错误";

    public static final int CODE_NORIGHT = 202;

    public static final String MSG_NORIGHT= "当前用户无此权限";
}
