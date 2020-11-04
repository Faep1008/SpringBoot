package com.faep.j2ee.test;

import java.math.BigDecimal;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.junit.Test;

import com.faep.common.utils.MoneyUtils;
import com.faep.common.utils.PwdUtils;
import com.faep.common.utils.SM4Utils;
import com.faep.common.utils.SmsUtils;

/**
 * 描述： 工具类测试
 * 作者： Faep
 * 创建时间： 2020-10-21 10:58
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
public class UtilTest
{

    @Test
    public void TestMoneyConvert() {
        double money = 500.00;
        BigDecimal numberOfMoney = new BigDecimal(money);
        String s = MoneyUtils.number2CNMontrayUnit(numberOfMoney);
        System.out.println("你输入的金额为：【" + money + "】   #--# [" + s + "]");
    }

    @Test
    public void testSendSms() {
        //String ret = SmsUtils.sendSms("1888888", "6789", "798");
        // SmsUtils.querySms("18888888");
        //System.out.println("单元测试执行结果：" + ret);
    }

    /**
     * 测试随机数（验证码）
     */
    @Test
    public void testRandomNum() {
        for (int i = 0; i < 520; i++) {
            String ret = String.format("%04d", new Random().nextInt(9999));
            System.out.println(ret);
        }
    }

    @Test
    public void testPwd() {

        String ret = PwdUtils.encrypt("11111");
        System.out.println(ret);
        String b = PwdUtils.encrypt(ret);
        System.out.println(b);
    }

    @Test
    public void testSM4() {
        String ret1 = SM4Utils.encryptEcb("ojjdzashwsgnbahg");
        System.out.println(ret1);

        String ret = SM4Utils.decryptEcb(ret1);
        System.out.println(ret);

    }

    @Test
    public void testPCUtils() {

    }

}
