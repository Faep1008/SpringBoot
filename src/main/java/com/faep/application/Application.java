package com.faep.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 作者： Faep
 * 创建时间： 2020/6/16 15:13
 * 版本： [1.0, 2020/6/16]
 * 描述： SpringBoot启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.faep"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}