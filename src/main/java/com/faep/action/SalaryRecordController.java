package com.faep.action;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faep.common.enums.ResultVO;
import com.faep.entity.SalaryRecord;
import com.faep.service.api.ISalaryRecordService;

/**
 * 描述： 工资管理后台Action
 * 作者： Faep
 * 创建时间： 2020-11-06 16:35
 * 版本： [1.0, 2020-11-06]
 * 版权： Faep
 */
@RestController
@RequestMapping("/salary")
public class SalaryRecordController
{

    @Autowired
    ISalaryRecordService salaryRecordService;

    @PostMapping("/add")
    public String addNewSalaryRecord(@RequestBody SalaryRecord salaryRecord) {
        salaryRecord.setRowguid(UUID.randomUUID().toString());
        salaryRecordService.addNewSalaryRecord(salaryRecord);
        return ResultVO.SUCCESS.getValue();
    }

    @PostMapping("/findall")
    public List<SalaryRecord> findAllSalaryRecords(@RequestBody String userguid) {

        return salaryRecordService.findAllSalaryRecords(userguid);
    }

    @PostMapping("/findbyyearmonth")
    public SalaryRecord findSalaryRecordsByYearMonth(@RequestBody String yearmonth, @RequestBody String userguid) {

        return salaryRecordService.findOneSalaryRecordByYear(yearmonth, userguid);
    }

    @PostMapping("/findbyyear")
    public List<SalaryRecord> findSalaryRecordsByYear(@RequestBody String year, @RequestBody String userguid) {

        return salaryRecordService.findSalaryRecordByYear(year, userguid);
    }

    @PostMapping("/update")
    public String updateSalaryRecord(@RequestBody SalaryRecord salaryRecord) {
        salaryRecordService.updateSalaryRecord(salaryRecord);
        return ResultVO.SUCCESS.getValue();
    }

}
