package com.spring.boot.springbootdemo.service;

import com.spring.boot.springbootdemo.model.TUser;

import java.util.List;

public interface UserService {
    List<TUser> getUserList();

    TUser getUserByPrimaryKey(Integer id);

    void addUser(String name,String sex);
}
