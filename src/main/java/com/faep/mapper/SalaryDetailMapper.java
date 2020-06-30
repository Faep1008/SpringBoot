package com.faep.mapper;

import com.faep.entity.SalaryDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述： 工资收支详细记录Mapper
 * 作者： Faep
 * 创建时间： 2020/6/30 11:04
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
@Mapper
public interface SalaryDetailMapper {

    /**
     * 新增一条收支记录
     */
    @Insert("insert into salaryDetail values (#{rowguid},#{userguid},#{opratedate},#{outlay},#{income},#{type})")
    int addSalaryRecord(SalaryDetail salaryDetail);

    /**
     * 获取某个用户下的所有收支记录
     */
    @Select("select * from salaryDetail where userguid=#{userguid} order by opratedate desc")
    List<SalaryDetail> getSalaryDetailListByUserGuid(String userguid);
}
