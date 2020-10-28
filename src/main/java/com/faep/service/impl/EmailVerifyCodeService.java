package com.faep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faep.entity.EmailVerifyCode;
import com.faep.mapper.EmailVerifyCodeMapper;
import com.faep.service.api.IEmailVerifyCodeService;

/**
 * 描述： 邮箱验证码Service实现类
 * 作者： Faep
 * 创建时间： 2020-10-28 14:16
 * 版本： [1.0, 2020-10-28]
 * 版权： Faep
 */
@Service
public class EmailVerifyCodeService implements IEmailVerifyCodeService
{

    @Autowired
    @SuppressWarnings("all")
    EmailVerifyCodeMapper emailVerifyCodeMapper;

    @Override
    public int addNewEmailVerifyCode(EmailVerifyCode code) {
        return emailVerifyCodeMapper.addNewEmailVerifyCode(code);
    }

    @Override
    public int updateEmailVerifyCodeByGuid(EmailVerifyCode code) {
        return emailVerifyCodeMapper.updateEmailVerifyCodeByGuid(code);
    }

    @Override
    public int updateEmailVerifyCodeByEmail(EmailVerifyCode code) {
        return emailVerifyCodeMapper.updateEmailVerifyCodeByEmail(code);
    }

    @Override
    public EmailVerifyCode findEmailVerifyCode(String email) {
        return emailVerifyCodeMapper.findEmailVerifyCode(email);
    }

    @Override
    public List<EmailVerifyCode> findAllEmailVerifyCode() {
        return emailVerifyCodeMapper.findAllEmailVerifyCode();
    }
}
