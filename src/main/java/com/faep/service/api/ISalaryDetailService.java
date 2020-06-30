package com.faep.service.api;

import com.faep.entity.SalaryDetail;

import java.util.List;

/**
 * 描述： 工资收支记录Service接口
 * 作者： Faep
 * 创建时间： 2020/6/30 11:10
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
public interface ISalaryDetailService {

    /**
     * 新增一条收支记录
     */
    int addSalaryRecord(SalaryDetail salaryDetail);

    /**
     * 获取某个用户下的所有收支记录
     */
    List<SalaryDetail> getSalaryDetailListByUserGuid(String userguid);
}
