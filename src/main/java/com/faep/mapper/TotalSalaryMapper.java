package com.faep.mapper;

import com.faep.entity.TotalSalary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 描述： 工资共计实体Mapper
 * 作者： Faep
 * 创建时间： 2020/6/30 11:00
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
@Mapper
public interface TotalSalaryMapper {

    /**
     * 新增一个总工资记录
     */
    @Insert("insert into totalsalary values (#{rowguid},#{totalsalary},#{opratedate},#{userguid})")
    int addAccountSalary(TotalSalary totalSalary);

    /**
     * 获取某个用户的总工资记录
     */
    @Select("select * from totalsalary where userguid=#{userguid}")
    TotalSalary getTotalSalaryByUserGuid(String userguid);

    /**
     * 更新某个用户的总工资记录
     */
    @Update("update totalsalary set totalsalary=#{totalsalary},opratedate=#{opratedate} where rowguid=#{rowguid}")
    int updateAccountSalary(TotalSalary totalSalary);
}
