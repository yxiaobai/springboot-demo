package com.spring.boot.springbootdemo.service;

import com.spring.boot.springbootdemo.utils.ApiResult;

/**
 * @Author zhaocai Ma
 * @Date 2019/1/8 15:15
 **/
public interface TestQuartzService {
    ApiResult<Boolean> openQuartz();

    ApiResult<Boolean> closeQuartz();
}
