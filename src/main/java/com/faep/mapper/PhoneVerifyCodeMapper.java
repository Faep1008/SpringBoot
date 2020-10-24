package com.faep.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.faep.entity.PhoneVerifyCode;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 描述： 手机验证码管理Mapper
 * 作者： Faep
 * 创建时间： 2020-10-24 13:55
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
@Mapper
public interface PhoneVerifyCodeMapper
{

    /**
     * 新增一条验证码记录
     * @param code
     * @return
     */
    @Insert("insert into PhoneVerifyCode values (#{rowguid},#{phone},#{verifycode},#{codegeneratetime},#{remark})")
    int addNewPhoneVerifyCode(PhoneVerifyCode code);

    @Update("update PhoneVerifyCode set verifycode=#{verifycode},codegeneratetime=#{codegeneratetime} where rowguid=#{rowguid}")
    int updatePhoneVerifyCodeByGuid(PhoneVerifyCode code);

    @Update("update PhoneVerifyCode set verifycode=#{verifycode},codegeneratetime=#{codegeneratetime} where phone=#{phone}")
    int updatePhoneVerifyCodeByPhone(PhoneVerifyCode code);

    @Select("select * from PhoneVerifyCode where phone=#{phone}")
    PhoneVerifyCode findPhoneVerifyCode(String phone);

    @Select("select * from PhoneVerifyCode order by codegeneratetime desc")
    List<PhoneVerifyCode> findAllPhoneVerifyCode();

}
