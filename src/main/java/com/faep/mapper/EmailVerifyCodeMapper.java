package com.faep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.faep.entity.EmailVerifyCode;

/**
 * 描述： 邮箱验证码管理Mapper
 * 作者： Faep
 * 创建时间： 2020-10-24 13:55
 * 版本： [1.0, 2020-10-24]
 * 版权： Faep
 */
@Mapper
public interface EmailVerifyCodeMapper
{

    /**
     * 新增一条验证码记录
     * 
     * @param code
     * @return
     */
    @Insert("insert into EmailVerifyCode values (#{rowguid},#{email},#{emailcode},#{codegeneratetime},#{remark})")
    int addNewEmailVerifyCode(EmailVerifyCode code);

    @Update("update EmailVerifyCode set emailcode=#{emailcode},codegeneratetime=#{codegeneratetime} where rowguid=#{rowguid}")
    int updateEmailVerifyCodeByGuid(EmailVerifyCode code);

    @Update("update EmailVerifyCode set emailcode=#{emailcode},codegeneratetime=#{codegeneratetime} where email=#{email}")
    int updateEmailVerifyCodeByEmail(EmailVerifyCode code);

    @Select("select * from EmailVerifyCode where email=#{email}")
    EmailVerifyCode findEmailVerifyCode(String email);

    @Select("select * from EmailVerifyCode order by codegeneratetime desc")
    List<EmailVerifyCode> findAllEmailVerifyCode();

}
