package com.faep.service.impl;

import com.faep.entity.SalaryDetail;
import com.faep.entity.TotalSalary;
import com.faep.mapper.SalaryDetailMapper;
import com.faep.service.api.ISalaryDetailService;
import com.faep.service.api.ITotalSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * 描述： 工资收支记录Service实现类
 * 作者： Faep
 * 创建时间： 2020/6/30 11:11
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
@Service
public class SalaryDetailService implements ISalaryDetailService {
    @Autowired
    @SuppressWarnings("all")
    SalaryDetailMapper salaryDetailMapper;

    @Autowired
    ITotalSalaryService totalSalaryService;

    @Override
    @Transactional
    public int addSalaryRecord(SalaryDetail salaryDetail) {
        int ret = salaryDetailMapper.addSalaryRecord(salaryDetail);
        String userguid = salaryDetail.getUserguid();
        TotalSalary totalSalary = totalSalaryService.getTotalSalaryByUserGuid(userguid);
        if(totalSalary == null){
            if("2".equals(salaryDetail.getType())){
                throw new RuntimeException("No Account To outlay!");
            }
            totalSalary = new TotalSalary();
            totalSalary.setRowguid(UUID.randomUUID().toString());
            totalSalary.setUserguid(userguid);
            totalSalary.setTotalsalary(salaryDetail.getIncome());
            totalSalary.setOpratedate(salaryDetail.getOpratedate());
            totalSalaryService.addAccountSalary(totalSalary);
            return ret;
        }
        totalSalary.setOpratedate(salaryDetail.getOpratedate());
        // 收入
        if("1".equals(salaryDetail.getType())){
            totalSalary.setTotalsalary(totalSalary.getTotalsalary().add(salaryDetail.getIncome()));
        }
        // 支出
        else if("2".equals(salaryDetail.getType())){
            BigDecimal remainSalary = totalSalary.getTotalsalary().subtract(salaryDetail.getOutlay());
            if(remainSalary.compareTo(BigDecimal.ZERO) < 0){
                throw new RuntimeException("Account has not enough salary!");
            }
            totalSalary.setTotalsalary(remainSalary);
        }
        // 未知类型
        else{
            throw new RuntimeException("UnKnow Salary Type!");
        }
        totalSalaryService.updateAccountSalary(totalSalary);
        return ret;
    }

    @Override
    public List<SalaryDetail> getSalaryDetailListByUserGuid(String userguid) {
        return salaryDetailMapper.getSalaryDetailListByUserGuid(userguid);
    }
}
