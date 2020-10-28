package com.faep.testspring;

import com.faep.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020-10-28 10:24
 * 版本： [1.0, 2020-10-28]
 * 版权： Faep
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringTest {

    @Autowired
    @SuppressWarnings("all")
    private JavaMailSender javaMailSender;

    @Test
    public void testSendMail(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("faep@qq.com");
        message.setTo("faep327@126.com");
        message.setSubject("这是标题Test");
        message.setText("验证码是：4096");
        javaMailSender.send(message);
        System.out.println("发送成功！");

    }

}
