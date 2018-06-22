package com.spring.boot.springbootdemo.service.impl;

import com.spring.boot.springbootdemo.mapper.TUserMapper;
import com.spring.boot.springbootdemo.model.TUser;
import com.spring.boot.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    @Override
    public List<TUser> getUserList() {
        List<TUser> userList = userMapper.getUserList();
        return userList;
    }
    @Transactional
    @Override
    public TUser getUserByPrimaryKey(Integer id) {
        TUser user = userMapper.selectByPrimaryKey(id);
        return user;
    }


    @Override
    public void addUser(String name,String sex){
        TUser user = new TUser();
        user.setName(name);
        user.setSex(sex);
        userMapper.insertSelective(user);
        String ss = "a";
        System.out.println(Integer.parseInt(ss));
    }
}
