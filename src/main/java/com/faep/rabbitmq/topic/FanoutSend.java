package com.faep.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/7 8:55
 * 版本： [1.0, 2020/7/7]
 * 版权： Faep
 */
//@Component
public class FanoutSend {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String message = "Hello FanoutSend.";
        logger.info("send:{}", message);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", message);
    }
}
