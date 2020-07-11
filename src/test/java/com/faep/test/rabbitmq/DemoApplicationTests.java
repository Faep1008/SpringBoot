package com.faep.test.rabbitmq;

import com.faep.rabbitmq.p2p.SimpleSend;
import com.faep.rabbitmq.topic.FanoutSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/7 8:46
 * 版本： [1.0, 2020/7/7]
 * 版权： Faep
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    SimpleSend simpleSend;

    @Autowired
    FanoutSend fanoutSend;

    /**
     * P2P测试
     */
    @Test
    public void simpleSend() {
        simpleSend.send();
    }

    @Test
    public void fanoutSend() {
        fanoutSend.send();
    }
}
