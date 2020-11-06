package com.faep.service.api;

import java.util.List;

import com.faep.entity.SalaryRecord;

/**
 * 描述： 工资记录Service接口
 * 作者： Faep
 * 创建时间： 2020-11-06 16:33
 * 版本： [1.0, 2020-11-06]
 * 版权： Faep
 */
public interface ISalaryRecordService
{

    int addNewSalaryRecord(SalaryRecord salaryRecord);

    List<SalaryRecord> findSalaryRecordByYear(String yearmonth);

    List<SalaryRecord> findAllSalaryRecords();

    SalaryRecord findOneSalaryRecordByYear(String yearmonth);

    int updateSalaryRecord(SalaryRecord salaryRecord);
}
