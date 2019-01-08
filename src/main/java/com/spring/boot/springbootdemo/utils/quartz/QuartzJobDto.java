package com.spring.boot.springbootdemo.utils.quartz;

/**
 * @Author zhaocai Ma
 * @Date 2019/01/08 14:59
 **/
public class QuartzJobDto {

    private final String SUBCRIBE_JOB_NAME = "SUBSCRIBE_JOB_";
    private final String SUBCRIBE_TRIGGER_NAME = "SUBSCRIBE_TRIGGER_";
    private final String SUBCRIBE_JOB_GROUP_NAME = "SUBCRIBE_JOB_GROUP";
    private final String SUBCRIBE_TRIGGER_GROUP_NAME = "SUBCRIBE_TRIGGER_GROUP";
    private static Class SUB_CLAZZ = SubscribeJob.class;

    private final String SUB_ONE_DAY = "*/30 * * * * ?";//工作日凌晨5点
    private final String SUB_CRON_DAY = "0 0 5 ? * 2-6 *";//工作日凌晨5点
    private final String SUB_CRON_ONE_WEEK = "0 0 5 ? * 2";//每周
    private final String SUB_CRON_TWO_WEEK = "0 0 5 1/15 * ?";//每2周
    private final String SUB_CRON_ONE_MONTH = "0 0 5 1 * ?";//每月
    private final String SUB_CRON_THREE_MONTH = "0 0 5 1 1/3 ?";//每3月

    private final String[] SUB_CRON = {SUB_ONE_DAY,SUB_CRON_DAY,SUB_CRON_ONE_WEEK,SUB_CRON_TWO_WEEK,SUB_CRON_ONE_MONTH,SUB_CRON_THREE_MONTH};


    private String jobName;
    private String triggerName;
    private String jobGroupName;
    private String triggerGroupName;
    private Class clazz;//定时类
    private String cron;//定时表达式

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public QuartzJobDto(String userCode, int type, int cronType){
        if (type == 1){
            //订阅定时任务，发邮件
            setJobGroupName(SUBCRIBE_JOB_GROUP_NAME+userCode);
            setJobName(SUBCRIBE_JOB_NAME+userCode);
            setTriggerGroupName(SUBCRIBE_TRIGGER_GROUP_NAME+userCode);
            setTriggerName(SUBCRIBE_TRIGGER_NAME+userCode);
            setClazz(SUB_CLAZZ);
            setCron(SUB_CRON[cronType]);
        }
    }
}
