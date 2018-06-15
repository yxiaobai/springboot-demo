package com.spring.boot.springbootdemo.service.impl;

import com.spring.boot.springbootdemo.mapper.TUserMapper;
import com.spring.boot.springbootdemo.model.TUser;
import com.spring.boot.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public TUser getUserByPrimaryKey(Integer id) {
        TUser user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
