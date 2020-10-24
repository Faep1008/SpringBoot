package com.faep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faep.entity.PhoneVerifyCode;
import com.faep.mapper.PhoneVerifyCodeMapper;
import com.faep.service.api.IPhoneVerifyCodeService;

/**
 * 描述： 手机验证码Service实现类
 * 作者： Faep
 * 创建时间： 2020-10-24 14:01
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
@Service
public class PhoneVerifyCodeService implements IPhoneVerifyCodeService
{

    @Autowired
    @SuppressWarnings("all")
    PhoneVerifyCodeMapper phoneVerifyCodeMapper;

    @Override
    public int addNewPhoneVerifyCode(PhoneVerifyCode code) {
        return phoneVerifyCodeMapper.addNewPhoneVerifyCode(code);
    }

    @Override
    public int updatePhoneVerifyCodeByGuid(PhoneVerifyCode code) {
        return phoneVerifyCodeMapper.updatePhoneVerifyCodeByGuid(code);
    }

    @Override
    public int updatePhoneVerifyCodeByPhone(PhoneVerifyCode code) {
        return phoneVerifyCodeMapper.updatePhoneVerifyCodeByPhone(code);
    }

    @Override
    public PhoneVerifyCode findPhoneVerifyCode(String phone) {
        return phoneVerifyCodeMapper.findPhoneVerifyCode(phone);
    }

    @Override
    public List<PhoneVerifyCode> findAllPhoneVerifyCode() {
        return phoneVerifyCodeMapper.findAllPhoneVerifyCode();
    }
}
