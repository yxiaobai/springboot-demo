package com.spring.boot.springbootdemo.utils.quartz;

import org.springframework.stereotype.Component;

/**
 * @Author zhaocai Ma
 * @Date 2019/01/08 14:59
 * 定时任务工具类
 */
@Component
public class QuartzUtil {
    public static String SUBCRIBE_JOB_NAME = "SUBSCRIBE_JOB_";
    public static String SUBCRIBE_TRIGGER_NAME = "SUBSCRIBE_TRIGGER_";
    public static String SUBCRIBE_JOB_GROUP_NAME = "SUBCRIBE_JOB_GROUP";
    public static String SUBCRIBE_TRIGGER_GROUP_NAME = "SUBCRIBE_TRIGGER_GROUP";



    public static void writeSubscribeJob(String userCode) {
        try {
//            QuartzJobDto jobDto = new QuartzJobDto(userCode);
//            QuartzManager.addJob();

            System.out.println("【系统启动】开始(每2秒输出一次)...");
            QuartzManager.addJob(SUBCRIBE_JOB_NAME + userCode, SUBCRIBE_JOB_GROUP_NAME,
                    SUBCRIBE_TRIGGER_NAME + userCode, SUBCRIBE_TRIGGER_GROUP_NAME,
                    SubscribeJob.class, "0/2 * * * * ?");
//            Thread.sleep(5000);
//            System.out.println("【修改时间】开始(每5秒输出一次)...");
//            QuartzManager.modifyJobTime(SUBCRIBE_JOB_NAME + userCode, SUBCRIBE_JOB_GROUP_NAME,
//                    SUBCRIBE_TRIGGER_NAME + userCode, SUBCRIBE_TRIGGER_GROUP_NAME,
//                    "0/5 * * * * ?");
            Thread.sleep(6000);
            System.out.println("【移除定时】开始...");
            QuartzManager.removeJob(SUBCRIBE_JOB_NAME + userCode, SUBCRIBE_JOB_GROUP_NAME,
                    SUBCRIBE_TRIGGER_NAME + userCode, SUBCRIBE_TRIGGER_GROUP_NAME);
            System.out.println("【移除定时】成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addJobBy(String userCode,int cronType) {
        try {
            QuartzJobDto jobDto = new QuartzJobDto(userCode,1,cronType);
            QuartzManager.addJobByDto(jobDto);
            System.out.println("【系统启动】开始...");
            /*QuartzManager.addJob(SUBCRIBE_JOB_NAME + userCode, SUBCRIBE_JOB_GROUP_NAME,
                    SUBCRIBE_TRIGGER_NAME + userCode, SUBCRIBE_TRIGGER_GROUP_NAME,
                    SubscribeJob.class, "0/2 * * * * ?");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void modifyJobTime(String userCode,int cronType) {
        try {
            System.out.println("【修改时间】开始...");
            QuartzJobDto jobDto = new QuartzJobDto(userCode,1,cronType);
            QuartzManager.modifyJobTimeDto(jobDto);
           /* QuartzManager.modifyJobTime(SUBCRIBE_JOB_NAME + userCode, SUBCRIBE_JOB_GROUP_NAME,
                    SUBCRIBE_TRIGGER_NAME + userCode, SUBCRIBE_TRIGGER_GROUP_NAME,
                    "0/5 * * * * ?");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeJob(String userCode , int cronType) {
        try {
            System.out.println("【移除定时】开始...");
            QuartzJobDto jobDto = new QuartzJobDto(userCode,1,cronType);
            QuartzManager.removeJobDto(jobDto);
           /* QuartzManager.removeJob(SUBCRIBE_JOB_NAME + userCode, SUBCRIBE_JOB_GROUP_NAME,
                    SUBCRIBE_TRIGGER_NAME + userCode, SUBCRIBE_TRIGGER_GROUP_NAME);
            System.out.println("【移除定时】成功");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdownJobs(){
        try {
            System.out.println("关闭所有定时任务  开始...");
            QuartzManager.shutdownJobs();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
