package com.faep.service.api;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020-10-28 11:26
 * 版本： [1.0, 2020-10-28]
 * 版权： Faep
 */
public interface IEMailService
{

    /**
     * 发送邮箱
     * 
     * @param account
     * @param title
     * @param msg
     * @return
     */
    String sendEmailMsg(String account, String title, String msg);

}
