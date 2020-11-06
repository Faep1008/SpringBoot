package com.faep.service.impl;

import com.faep.common.enums.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.faep.service.api.IEMailService;
import com.faep.vo.config.EmailConfigVo;

/**
 * 描述： Email service
 * 作者： Faep
 * 创建时间： 2020-10-28 11:27
 * 版本： [1.0, 2020-10-28]
 * 版权： Faep
 */
@Service
public class EMailService implements IEMailService
{
    @Autowired
    @SuppressWarnings("all")
    private JavaMailSender javaMailSender;

    @Autowired
    EmailConfigVo emailConfigVo;

    @Override
    public String sendEmailMsg(String account, String title, String msg) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailConfigVo.getUsername());
            message.setTo(account);
            message.setSubject(title);
            message.setText(msg);
            javaMailSender.send(message);
            return ResultVO.SUCCESS.getValue();
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResultVO.ERROR.getValue() + e.getMessage();
        }
    }
}
