package com.faep.rabbitmq.p2p;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/7 8:45
 * 版本： [1.0, 2020/7/7]
 * 版权： Faep
 */
//@Component
//@RabbitListener(queues = "simple")
public class SimpleReceive {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String message) {
        logger.info("Receive :{}", message);
    }
}
