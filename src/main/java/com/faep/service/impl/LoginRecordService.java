package com.faep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faep.entity.LoginRecord;
import com.faep.mapper.LoginRecordMapper;
import com.faep.service.api.ILoginRecordService;

/**
 * 描述： 登录历史记录Service
 * 作者： Faep
 * 创建时间： 2020-11-03 14:31
 * 版本： [1.0, 2020-11-03]
 * 版权： Faep
 */
@Service
public class LoginRecordService implements ILoginRecordService
{

    @Autowired
    @SuppressWarnings("all")
    LoginRecordMapper loginRecordMapper;

    @Override
    public int addNewRecord(LoginRecord record) {
        return loginRecordMapper.addNewRecord(record);
    }

    @Override
    public List<LoginRecord> findAllRecordByUser(String userguid) {
        return loginRecordMapper.findAllRecordByUser(userguid);
    }
}
