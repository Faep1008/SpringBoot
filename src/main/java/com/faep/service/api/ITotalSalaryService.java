package com.faep.service.api;

import com.faep.entity.TotalSalary;

/**
 * 描述： 总收入Service接口
 * 作者： Faep
 * 创建时间： 2020/6/30 11:13
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
public interface ITotalSalaryService {

    /**
     * 新增一个总收入记录
     */
    int addAccountSalary(TotalSalary totalSalary);

    /**
     * 获取某个用户下总工资收入记录
     */
    TotalSalary getTotalSalaryByUserGuid(String userguid);

    /**
     * 修改某个用户下总工资收入记录
     */
    int updateAccountSalary(TotalSalary totalSalary);
}
