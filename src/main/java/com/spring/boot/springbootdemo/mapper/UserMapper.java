package com.spring.boot.springbootdemo.mapper;

import com.spring.boot.springbootdemo.mapper.mbg.TUserMapper;
import com.spring.boot.springbootdemo.model.TUser;

/**
 * @Author: Yi xiaobai
 * @Date: 2018/9/29 0029 下午 5:08
 */
public interface UserMapper extends TUserMapper {
    TUser getLoginUser(TUser user);
}
