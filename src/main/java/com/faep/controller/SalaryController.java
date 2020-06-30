package com.faep.controller;

import com.faep.common.enums.ResultVO;
import com.faep.common.enums.SalaryType;
import com.faep.entity.SalaryDetail;
import com.faep.service.api.ISalaryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/6/30 11:21
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    ISalaryDetailService salaryDetailService;

    /**
     * 转账
     */
    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transfer() {
        try{
            SalaryDetail salaryDetail = new SalaryDetail();
            salaryDetail.setRowguid(UUID.randomUUID().toString());
            salaryDetail.setIncome(new BigDecimal(888));
            salaryDetail.setOutlay(new BigDecimal(222));
            salaryDetail.setOpratedate(new Date());
            salaryDetail.setType(SalaryType.支出.getValue());
            salaryDetail.setUserguid("744396a7-f65d-4020-9aaf-fa6e93b29f30");
            salaryDetailService.addSalaryRecord(salaryDetail);
            return ResultVO.成功.getValue();
        }
        catch (Exception e){
            return ResultVO.失败.getValue() + ":" + e.getMessage();
        }
    }

}
