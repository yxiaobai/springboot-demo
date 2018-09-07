package com.spring.boot.springbootdemo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by MZC on 18-9-7
 * @Configuration：表明该类是一个配置类
 * @EnableAsync：开启异步事件的支持
 * 此处成员变量应该使用@Value从配置中读取
 */
@Configuration
@EnableAsync
public class AsyncConfig {
    /*核心线程数*/
    private int corePoolSize = 10;
    /*最大线程数*/
    private int maxPoolSize = 200;
    /*队列最大长度*/
    private int queueCapacity = 10;

    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
