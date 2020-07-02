package com.faep.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/2 8:41
 * 版本： [1.0, 2020/7/2]
 * 版权： Faep
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    /**
     * 测试生成线程快照
     */
    @RequestMapping(value = "/thread", method = RequestMethod.GET)
    public String testThreadSnapShot() {

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕！");
            });
            t.start();
        }
        return "OK";
    }

}
