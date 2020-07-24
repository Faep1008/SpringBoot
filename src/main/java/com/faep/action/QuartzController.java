package com.faep.action;

import com.faep.job.TimeJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/1 9:39
 * 版本： [1.0, 2020/7/1]
 * 版权： Faep
 */
@RestController
@RequestMapping("/quartz")
public class QuartzController {

    /**
     * 任务的增删查改都是基于 Scheduler 类，SpringBoot 自带的 QuartzAutoConfiguration 对其进行了注册
     */
    @Autowired
    private Scheduler scheduler;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void index() throws SchedulerException {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey("cj", "123");
            CronTrigger triggerOld = null;
            triggerOld = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (triggerOld == null) {
                addJob("cj", "123", "trig_cj", "trig_123",
                        TimeJob.class, "0/2 * * * * ?");
            } else {
                String oldTime = triggerOld.getCronExpression();
                if (!oldTime.equalsIgnoreCase("0/9 * * * * ?")) {
                    updateJob(triggerKey, "0/3 * * * * ?");
                }
                System.out.println("当前job已存在--------------------------------------------");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除job
     *
     * @param triggerName 触发器名称
     * @param triggerGroup 触发器分组
     * @param jobName 任务名称
     * @param jobGroup 任务分组
     */
    public void deleteJob(String triggerName, String triggerGroup, String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
        scheduler.pauseTrigger(triggerKey);
        scheduler.unscheduleJob(triggerKey);
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        scheduler.deleteJob(jobKey);
    }

    /**
     * 修改定时任务
     *
     * @param oldTriggerKey 需要修改的TriggerKey 也就是唯一标识
     * @param cron 新的cron表达式
     */
    public void updateJob(TriggerKey oldTriggerKey, String cron) {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(oldTriggerKey).withSchedule(scheduleBuilder).build();
        try {
            scheduler.rescheduleJob(oldTriggerKey, cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增job任务
     *
     * @param jobName job名称
     * @param jobGroupName job分组名称
     * @param triggerName 触发器名称
     * @param triggerGroupName 触发器分组名称
     * @param jobClass 需要执行的job.class
     * @param cron cron 表达式
     */
    public void addJob(String jobName, String jobGroupName,
                       String triggerName, String triggerGroupName, Class jobClass, String cron) throws SchedulerException {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);

    }

}
