package com.spring.boot.springbootdemo.controller;

import com.spring.boot.springbootdemo.model.TUser;
import com.spring.boot.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@EnableAutoConfiguration
public class UserController {
private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserDetail/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TUser getUserDetail(@PathVariable Integer id){
        TUser users = userService.getUserByPrimaryKey(id);
        logger.info(id.toString());
        return users;
    }
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public List<TUser> getUserList(){
        List<TUser> users = userService.getUserList();
        logger.info("获取成功");
        return users;
    }
}
