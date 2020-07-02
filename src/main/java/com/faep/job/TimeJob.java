package com.faep.job;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/1 9:37
 * 版本： [1.0, 2020/7/1]
 * 版权： Faep
 */
@Component
public class TimeJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        System.out.println("执行 timeJob at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
