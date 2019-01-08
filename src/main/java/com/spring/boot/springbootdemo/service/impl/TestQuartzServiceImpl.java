package com.spring.boot.springbootdemo.service.impl;

import com.spring.boot.springbootdemo.service.TestQuartzService;
import com.spring.boot.springbootdemo.utils.ApiResult;
import com.spring.boot.springbootdemo.utils.quartz.QuartzUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Author zhaocai Ma
 * @Date 2019/1/8 15:15
 **/
@Service
public class TestQuartzServiceImpl implements TestQuartzService {
    private Logger logger = LoggerFactory.getLogger(TestQuartzServiceImpl.class);

    /**
     * 添加定时任务
     * @return
     */
    @Override
    public ApiResult<Boolean> openQuartz() {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        try {
            //查询数据库  获取不同用户的不同定时情况  for循环 设置不同的时间
            QuartzUtil.addJobBy("userCode",1);
            result.setData(Boolean.TRUE);
        }catch (Exception e){
            logger.error("opemQuatz error.........",e);
            result.setData(Boolean.FALSE);
        }
        return result;
    }

    /**
     * 移除定时任务
     * @return
     */
    @Override
    public ApiResult<Boolean> closeQuartz() {
        ApiResult<Boolean> result = ApiResult.makeSuccessResult();
        try {
            QuartzUtil.shutdownJobs();
            result.setData(Boolean.TRUE);
        }catch (Exception e){
            logger.error("closeQuartz error.........",e);
            result.setData(Boolean.FALSE);
        }
        return result;
    }

    /**
     * 单个 定时  修改时间  调用  modifyJobTime 方法
     *
     * 单个 定时  取消任务  调用  removeJob 方法
     *
     * */
}
