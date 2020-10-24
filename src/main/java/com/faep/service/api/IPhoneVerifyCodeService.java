package com.faep.service.api;

import java.util.List;

import com.faep.entity.PhoneVerifyCode;

/**
 * 描述： 手机验证码Service接口
 * 作者： Faep
 * 创建时间： 2020-10-24 14:00
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
public interface IPhoneVerifyCodeService
{

    int addNewPhoneVerifyCode(PhoneVerifyCode code);

    int updatePhoneVerifyCodeByGuid(PhoneVerifyCode code);

    int updatePhoneVerifyCodeByPhone(PhoneVerifyCode code);

    PhoneVerifyCode findPhoneVerifyCode(String phone);

    List<PhoneVerifyCode> findAllPhoneVerifyCode();

}
