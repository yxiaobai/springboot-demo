package com.spring.boot.springbootdemo.service;

import com.spring.boot.springbootdemo.dto.requestDto.InsertUserDto;
import com.spring.boot.springbootdemo.dto.responseDto.LoginResponseDto;
import com.spring.boot.springbootdemo.model.TUser;
import com.spring.boot.springbootdemo.utils.ApiResult;

import java.util.List;
public interface UserService {

    ApiResult<TUser> getUserByID(Integer id);

    ApiResult<List<TUser>> getUserList();

    ApiResult<Boolean> addUser(InsertUserDto dto);

    ApiResult<LoginResponseDto> selectUser(TUser user);

    ApiResult<Boolean> delUser(Integer id);

    ApiResult<Boolean> updateUser(TUser user);
}
