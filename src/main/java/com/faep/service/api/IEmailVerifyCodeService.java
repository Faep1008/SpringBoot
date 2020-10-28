package com.faep.service.api;

import java.util.List;

import com.faep.entity.EmailVerifyCode;

/**
 * 描述： 邮箱验证码Service接口
 * 作者： Faep
 * 创建时间： 2020-10-24 14:00
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
public interface IEmailVerifyCodeService
{

    int addNewEmailVerifyCode(EmailVerifyCode code);

    int updateEmailVerifyCodeByGuid(EmailVerifyCode code);

    int updateEmailVerifyCodeByEmail(EmailVerifyCode code);

    EmailVerifyCode findEmailVerifyCode(String email);

    List<EmailVerifyCode> findAllEmailVerifyCode();

}
