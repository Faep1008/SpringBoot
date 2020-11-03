package com.faep.service.api;

import java.util.List;

import com.faep.entity.LoginRecord;

/**
 * 描述： 登录历史记录Service
 * 作者： Faep
 * 创建时间： 2020-11-03 14:31
 * 版本： [1.0, 2020-11-03]
 * 版权： Faep
 */
public interface ILoginRecordService
{
    /**
     * 新增记录
     *
     * @return
     */
    int addNewRecord(LoginRecord record);

    /**
     * 查询用户下所有登录历史记录
     *
     * @param userguid
     * @return
     */
    List<LoginRecord> findAllRecordByUser(String userguid);
}
