package com.spring.boot.springbootdemo.controller;

import com.spring.boot.springbootdemo.dto.requestDto.InsertUserDto;
import com.spring.boot.springbootdemo.dto.responseDto.LoginResponseDto;
import com.spring.boot.springbootdemo.model.TUser;
import com.spring.boot.springbootdemo.service.UserService;
import com.spring.boot.springbootdemo.utils.ApiResult;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@EnableAutoConfiguration
public class UserController {
private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 查看明细
     * @param id  用户ID
     * @return
     */
    @RequestMapping(value = "auth_Dt1/getUserDetail/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<TUser> getUserDetail(@PathVariable Integer id){
        ApiResult<TUser> result = userService.getUserByID(id);
        return result;
    }

    /**
     * 获取用户List
     * @return
     */
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<List<TUser>> getUserList(){
        ApiResult<List<TUser>> result = userService.getUserList();
        return result;
    }

    /**
     *  新增用户信息
     * @param dto
     * @return
     */

    @RequestMapping(value = "auth_U1/addUser")
    @ResponseBody
    public ApiResult<Boolean> addUser(@RequestBody InsertUserDto dto){
        logger.info(dto.toString());
        ApiResult<Boolean> result  = userService.addUser(dto);
        return result;
    }

    /**
     * 登陆
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult loginUser(HttpServletRequest request, @RequestBody TUser user){
        ApiResult<LoginResponseDto> result = userService.selectUser(user);
        if (result.getData() != null) {
            request.getSession().setAttribute("user", result.getData());
        }
        return result;
    }

    /**
     * 登出
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "logOut", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<Boolean> logOut(HttpServletRequest request, HttpSession session) {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        session.removeAttribute("user");
        result.setData(Boolean.TRUE);
        return result;
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "auth_D1",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<Boolean> delUser(@PathVariable Integer id){
        ApiResult<Boolean> result = userService.delUser(id);
        return result;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "auth_U2",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<Boolean> updateUser(@RequestBody TUser user){
        ApiResult<Boolean> result = userService.updateUser(user);
        return result;
    }

    /**
     * 测试权限
     * @return
     */
    @RequestMapping(value = "auth_R1/soutRole",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<Boolean> soutRole(){
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        result.setMsg("测试权限是否通过");
        result.setData(Boolean.TRUE);
        return result;
    }
}
