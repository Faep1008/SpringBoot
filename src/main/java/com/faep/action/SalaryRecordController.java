package com.faep.action;

import java.util.List;
import java.util.UUID;

import com.faep.common.enums.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faep.entity.SalaryRecord;
import com.faep.service.api.ISalaryRecordService;

/**
 * 描述： [ ]
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
        return ResultVO.成功.getValue();
    }

    @PostMapping("/findall")
    public List<SalaryRecord> findAllSalaryRecords() {

        return salaryRecordService.findAllSalaryRecords();
    }

    @PostMapping("/findbyyearmonth")
    public SalaryRecord findSalaryRecordsByYearMonth(@RequestBody String yearmonth) {

        return salaryRecordService.findOneSalaryRecordByYear(yearmonth);
    }

    @PostMapping("/findbyyear")
    public List<SalaryRecord> findSalaryRecordsByYear(@RequestBody String year) {

        return salaryRecordService.findSalaryRecordByYear(year);
    }

    @PostMapping("/update")
    public String updateSalaryRecord(@RequestBody SalaryRecord salaryRecord) {
        salaryRecordService.updateSalaryRecord(salaryRecord);
        return ResultVO.成功.getValue();
    }

}
