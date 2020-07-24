package com.faep.rabbitmq.p2p;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 描述： 消息提供者
 * 作者： Faep
 * 创建时间： 2020/7/7 8:44
 * 版本： [1.0, 2020/7/7]
 * 版权： Faep
 */
//@Component
public class SimpleSend {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = "Hello Spring Boot " + simpleDateFormat.format(new Date());
        amqpTemplate.convertAndSend("simple", message);
        logger.info("消息推送成功！");
    }
}
