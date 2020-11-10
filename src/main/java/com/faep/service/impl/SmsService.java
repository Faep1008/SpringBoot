package com.faep.service.impl;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.faep.common.utils.SmsUtils;
import com.faep.entity.FrameConfig;
import com.faep.service.api.IFrameConfigService;
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

    private static final Logger log = LoggerFactory.getLogger(SmsService.class);

    @Autowired
    IFrameConfigService frameConfigService;

    private String ACCESSKEYID;
    private String ACCESSKEYSECRET;

    public void initData() {
        FrameConfig accesskeyid = frameConfigService.findFrameConfigByKey("ACCESSKEYID");
        FrameConfig accesskeysecret = frameConfigService.findFrameConfigByKey("ACCESSKEYSECRET");
        if (accesskeyid != null) {
            ACCESSKEYID = accesskeyid.getValue();
        }
        if (accesskeysecret != null) {
            ACCESSKEYSECRET = accesskeysecret.getValue();
        }
        log.info("ACCESSKEYID=" + ACCESSKEYID);
        log.info("ACCESSKEYSECRET=" + ACCESSKEYSECRET);
    }

    @Override
    public String sendSms(String phone, String code, String templateCode) {
        if (StringUtils.isEmpty(ACCESSKEYID) || StringUtils.isEmpty(ACCESSKEYSECRET)) {
            initData();
        }
        return SmsUtils.sendSms(phone, code, templateCode, ACCESSKEYID, ACCESSKEYSECRET);
    }

    @Override
    public String generateVerifyCode() {
        return String.format("%04d", new Random().nextInt(9999));
    }

    @Override
    public boolean isVerifyCodeExpired(Date codeGenerateTime) {
        if (codeGenerateTime == null) {
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
