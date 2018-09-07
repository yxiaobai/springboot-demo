package com.spring.boot.springbootdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by MZC on 18-9-7
 */
@Component
public class ScheduledService_Asy {
    private Logger logger = LoggerFactory.getLogger(ScheduledService_Asy.class);
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        logger.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }
    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        logger.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
    }
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        logger.info("=====>>>>>fixedDelay{}",System.currentTimeMillis());
    }
}
