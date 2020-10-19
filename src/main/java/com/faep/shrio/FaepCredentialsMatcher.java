package com.faep.shrio;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha384Hash;

/**
 * 描述： 验证密码 查找到了该用户 自定义密码验证器
 * 作者： Faep
 * 创建时间： 2020-10-19 15:18
 * 版本： [1.0, 2020-10-19]
 * 版权： Faep
 */
public class FaepCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String pwd = encrypt(String.valueOf(usernamePasswordToken.getPassword()));
        String mysqlpwd = (String) info.getCredentials();
        return this.equals(pwd, mysqlpwd);
    }

    //将传进来的密码进行加密的方法
    private String encrypt(String data){
        String sha384Hex=new Sha384Hash(data).toBase64();
        return sha384Hex;
    }

}
