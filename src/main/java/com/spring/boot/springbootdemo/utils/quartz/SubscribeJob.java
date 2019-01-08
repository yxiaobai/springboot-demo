package com.spring.boot.springbootdemo.utils.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @Author zhaocai Ma
 * @Date 2019/01/08 14:59
 * 订阅JOB===将变更内容发邮件
 */
@Component
public class SubscribeJob implements Job  {
    /*@Autowired
    private QuartzService quartzService;
    public static SubscribeJob subscribeJob;

    @PostConstruct
    public void init(){
        subscribeJob = this;
        subscribeJob.quartzService = this.quartzService;
    }*/

    @Override
    public void execute(JobExecutionContext jobExecutionContext ) throws JobExecutionException {
        // 发送邮件
        System.out.println(new Date() + ":发送定时邮件...");
//        quartzService = (QuartzService) SubscribeJob.applicationContext.getBean("quartzService");

//        EmailSender.sendTextMail()
//        jobExecutionContext.get
        //EmailSender emailSender = new EmailSender();
        //Map<String,String> dataMap = new HashMap<String,String>();
        //emailSender.sendSubscribeMail("", emailSender.getMailContentByTemplate(dataMap,"1"));
     //   userService.email();



        // subscribeJob.quartzService.email(jobExecutionContext.getJobDetail().getKey().getName().substring(14));
        System.out.println(new Date() + ":发送定时邮件结束...");
    }
}
