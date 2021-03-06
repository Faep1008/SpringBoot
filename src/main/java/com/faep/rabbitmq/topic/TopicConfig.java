package com.faep.rabbitmq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/7 8:52
 * 版本： [1.0, 2020/7/7]
 * 版权： Faep
 */
//@Configuration
public class TopicConfig
{

    private final String message = "topic.message";
    private final String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(this.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(this.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
