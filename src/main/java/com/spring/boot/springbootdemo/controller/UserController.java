package com.spring.boot.springbootdemo.controller;

import com.spring.boot.springbootdemo.model.TUser;
import com.spring.boot.springbootdemo.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserDetail/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TUser getUserDetail(@PathVariable Integer id){
        TUser users = userService.getUserByPrimaryKey(id);
        return users;
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public List<TUser> getUserList(){
        List<TUser> users = userService.getUserList();
        return users;
    }
}
