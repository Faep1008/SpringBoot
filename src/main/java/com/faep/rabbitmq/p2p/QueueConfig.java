package com.faep.rabbitmq.p2p;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述： 队列配置
 * 作者： Faep
 * 创建时间： 2020/7/7 8:42
 * 版本： [1.0, 2020/7/7]
 * 版权： Faep
 */
@Configuration
public class QueueConfig {
    @Bean
    public Queue simpleQueue() {
        return new Queue("simple");
    }

    @Bean
    public Queue simpleOneToMany() {
        return new Queue("simpleOneToMany");
    }
}
