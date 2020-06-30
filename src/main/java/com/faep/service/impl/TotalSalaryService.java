package com.faep.service.impl;

import com.faep.entity.TotalSalary;
import com.faep.mapper.TotalSalaryMapper;
import com.faep.service.api.ITotalSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述： 总收入Service实现类
 * 作者： Faep
 * 创建时间： 2020/6/30 11:14
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
@Service
public class TotalSalaryService implements ITotalSalaryService {
    @Autowired
    @SuppressWarnings("all")
    TotalSalaryMapper totalSalaryMapper;

    @Override
    public int addAccountSalary(TotalSalary totalSalary) {
        return totalSalaryMapper.addAccountSalary(totalSalary);
    }

    @Override
    public TotalSalary getTotalSalaryByUserGuid(String userguid) {
        return totalSalaryMapper.getTotalSalaryByUserGuid(userguid);
    }

    @Override
    public int updateAccountSalary(TotalSalary totalSalary) {
        return totalSalaryMapper.updateAccountSalary(totalSalary);
    }
}
