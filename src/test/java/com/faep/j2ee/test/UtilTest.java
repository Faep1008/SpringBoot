package com.faep.j2ee.test;

import com.faep.common.utils.MoneyUtils;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 描述： 工具类测试
 * 作者： Faep
 * 创建时间： 2020-10-21 10:58
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
public class UtilTest {

    @Test
    public void TestMoneyConvert(){
        double money = 500.00;
        BigDecimal numberOfMoney = new BigDecimal(money);
        String s = MoneyUtils.number2CNMontrayUnit(numberOfMoney);
        System.out.println("你输入的金额为：【" + money + "】   #--# [" + s.toString()
                + "]");
    }

}
