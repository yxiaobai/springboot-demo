package com.spring.boot.springbootdemo.controller;

import com.spring.boot.springbootdemo.service.TestQuartzService;
import com.spring.boot.springbootdemo.utils.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaocai Ma
 * @Date 2019/1/8 15:14
 **/
@RestController
@EnableAutoConfiguration
@RequestMapping("/testQuartz")
public class TestQuartzController {
    @Autowired
    private TestQuartzService quartzService;

    /**
     * 添加定时任务
     */
    @RequestMapping(value = "/openQuartz",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<Boolean> openQuartz(){
        ApiResult<Boolean> result = quartzService.openQuartz();
        return result;
    }

    /**
     * 关闭定时任务
     */
    @RequestMapping(value = "/closeQuartz",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<Boolean> closeQuartz(){
        ApiResult<Boolean> result = quartzService.closeQuartz();
        return result;
    }
}
