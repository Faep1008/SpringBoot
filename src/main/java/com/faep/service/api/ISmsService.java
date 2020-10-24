package com.faep.service.api;

import java.util.Date;

/**
 * 描述： 短信服务接口Service
 * 作者： Faep
 * 创建时间： 2020-10-24 10:17
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
public interface ISmsService
{

    /**
     * 发送验证码
     * 
     * @param phone
     * @param code
     * @return
     */
    String sendSms(String phone, String code, String templateCode);

    /**
     * 获取四位随机验证码
     * 
     * @return
     */
    String generateVerifyCode();

    /**
     * 判断验证码是否过期
     * 
     * @param codeGenerateTime
     * @return
     */
    boolean isVerifyCodeExpired(Date codeGenerateTime);

    /**
     * 是否可以发送验证码
     * 如果已经发送且在有效期内则不允许再次发送
     * 
     * @param code
     * @param codeGenerateTime
     * @return
     */
    boolean isCanSendSms(String code, Date codeGenerateTime);

    /**
     * 判断验证码是否通过
     * 
     * @return
     */
    boolean isCodeValidPass(String inputCode, String smsCode, Date codeGenerateTime);
}
