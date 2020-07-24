package com.faep.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述： 消息的生产者
 * 作者： Faep
 * 创建时间： 2020/7/7 8:53
 * 版本： [1.0, 2020/7/7]
 * 版权： Faep
 */
//@Component
public class TopicSend {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1() {
        String message = "message 1";
        logger.info("send:{}", message);
        rabbitTemplate.convertAndSend("topicExchange", "topic.message", message);
    }

    public void send2() {
        String message = "message 2";
        logger.info("send:{}", message);
        rabbitTemplate.convertAndSend("topicExchange", "topic.messages", message);
    }
}
