package com.faep.service.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.faep.common.utils.SmsUtils;
import com.faep.service.api.ISmsService;

/**
 * 描述： 短信服务Service实现类
 * 作者： Faep
 * 创建时间： 2020-10-24 10:17
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
@Service
public class SmsService implements ISmsService
{
    @Override
    public String sendSms(String phone, String code, String templateCode) {
        return SmsUtils.sendSms(phone, code, templateCode);
    }

    @Override
    public String generateVerifyCode() {
        return String.format("%04d", new Random().nextInt(9999));
    }

    @Override
    public boolean isVerifyCodeExpired(Date codeGenerateTime) {
        if(codeGenerateTime == null){
            return true;
        }
        Date now = new Date();
        long nowTime = now.getTime();
        long sendTime = codeGenerateTime.getTime();
        if (nowTime - sendTime > 600000) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isCanSendSms(String code, Date codeGenerateTime) {
        // 如果不为空且在有效期内则返回不用重新发送
        if (!StringUtils.isEmpty(code) && isVerifyCodeExpired(codeGenerateTime)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isCodeValidPass(String inputCode, String smsCode, Date codeGenerateTime) {
        if (!StringUtils.isEmpty(inputCode)) {
            if (inputCode.equals(smsCode) && isVerifyCodeExpired(codeGenerateTime)) {
                return true;
            }
        }
        return false;
    }

}
