package com.faep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.faep.entity.LoginRecord;

/**
 * 描述： 登录历史记录Mapper
 * 作者： Faep
 * 创建时间： 2020-11-03 14:25
 * 版本： [1.0, 2020-11-03]
 * 版权： Faep
 */
@Mapper
public interface LoginRecordMapper
{

    /**
     * 新增记录
     * 
     * @return
     */
    @Insert("insert into LoginRecord values (#{rowguid}, #{userguid}, #{loginid}, #{logintype}, #{logindate}, #{loginip}, #{loginmac}, #{remark})")
    int addNewRecord(LoginRecord record);

    /**
     * 查询用户下所有登录历史记录
     * 
     * @param userguid
     * @return
     */
    @Select("select * from LoginRecord where userguid=#{userguid} order by logindate desc")
    List<LoginRecord> findAllRecordByUser(String userguid);

}
