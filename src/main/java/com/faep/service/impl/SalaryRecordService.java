package com.faep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faep.entity.SalaryRecord;
import com.faep.mapper.SalaryRecordMapper;
import com.faep.service.api.ISalaryRecordService;

/**
 * 描述： 工资记录Service实现类
 * 作者： Faep
 * 创建时间： 2020-11-06 16:33
 * 版本： [1.0, 2020-11-06]
 * 版权： Faep
 */
@Service
public class SalaryRecordService implements ISalaryRecordService
{

    @Autowired
    @SuppressWarnings("all")
    SalaryRecordMapper salaryRecordMapper;

    @Override
    public int addNewSalaryRecord(SalaryRecord salaryRecord) {
        return salaryRecordMapper.addNewSalaryRecord(salaryRecord);
    }

    @Override
    public List<SalaryRecord> findSalaryRecordByYear(String yearmonth, String userguid) {
        return salaryRecordMapper.findSalaryRecordByYear(yearmonth, userguid);
    }

    @Override
    public List<SalaryRecord> findAllSalaryRecords(String userguid) {
        return salaryRecordMapper.findAllSalaryRecords(userguid);
    }

    @Override
    public SalaryRecord findOneSalaryRecordByYear(String yearmonth, String userguid) {
        return salaryRecordMapper.findOneSalaryRecordByYear(yearmonth, userguid);
    }

    @Override
    public int updateSalaryRecord(SalaryRecord salaryRecord) {
        return salaryRecordMapper.updateSalaryRecord(salaryRecord);
    }
}
