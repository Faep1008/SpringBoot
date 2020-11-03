package com.faep.common.enums;

/**
 * 描述： 登录类型枚举
 * 作者： Faep
 * 创建时间： 2020-11-03 15:16
 * 版本： [1.0, 2020-11-03]
 * 版权： Faep
 */
public enum LoginType
{

    AccountPwd("用户名密码"), PhoneCode("手机验证码"), EmailCode("邮箱验证码");

    String type;

    LoginType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
