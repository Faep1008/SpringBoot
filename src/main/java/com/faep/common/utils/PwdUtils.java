package com.faep.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * 描述： 密码操作工具类
 * 作者： Faep
 * 创建时间： 2020-10-27 14:29
 * 版本： [1.0, 2020-10-27]
 * 版权： Faep
 */
public class PwdUtils
{

    /**
     * 密码加密
     * 
     * @param password
     * @return
     */
    public static String encrypt(String password) {
        if (StringUtils.isEmpty(password)) {
            return "";
        }
        String sga256Str = DigestUtils.sha256Hex(password);
        String shStr = DigestUtils.shaHex(sga256Str);
        String md5Str = DigestUtils.md5Hex(shStr);
        return md5Str;
    }

    /**
     * 判断密码是否相等
     * 
     * @param inputPwd
     * @param dbPwd
     * @return
     */
    public static boolean isPwdPass(String inputPwd, String dbPwd) {
        return encrypt(inputPwd).equals(dbPwd);
    }

    /**
     * 判断密码格式是否通过
     * 
     * @param pwd
     * @return
     */
    public static String pwdFormatValid(String password) {
        if (StringUtils.isEmpty(password)) {
            return "密码不能为空！";
        }
        if (password.length() < 5) {
            return "密码长度不能小于5位！";
        }
        return "OK";
    }

}
