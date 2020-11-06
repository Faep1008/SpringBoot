package com.faep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.faep.entity.SalaryRecord;

/**
 * 描述： 工资记录Mapper
 * 作者： Faep
 * 创建时间： 2020-11-06 16:26
 * 版本： [1.0, 2020-11-06]
 * 版权： Faep
 */
@Mapper
public interface SalaryRecordMapper
{

    @Insert("insert into SalaryRecord values (#{rowguid}, #{companyname}, #{jobnumber}, #{username}, #{department}, #{yearmonth}, #{entrydate}, #{jobtitle}, #{jobclassification}, #{providentfundnum}, #{socialsecuritynum}, #{jobrank}, #{jobranksalary}, #{floatingbonus}, #{holidaysalary}, #{totalcurrentincome}, #{housingfund}, #{medicalinsurance}, #{pensioninsurance}, #{unemploymentinsurance}, #{cumulativeincome}, #{cumulativespecialdeduction}, #{cumulativedeductions}, #{cumulativetaxableincome}, #{cumulativetaxwithholding}, #{cumulativeprepaidtax}, #{totalshouldgetsalary}, #{currenttaxpayable}, #{smountactuallysalary}, #{userguid})")
    int addNewSalaryRecord(SalaryRecord salaryRecord);

    @Select("select * from SalaryRecord where yearmonth like concat('%',#{yearmonth},'%') and userguid=#{userguid} order by yearmonth desc")
    List<SalaryRecord> findSalaryRecordByYear(String yearmonth, String userguid);

    @Select("select * from SalaryRecord where userguid=#{userguid} order by yearmonth desc")
    List<SalaryRecord> findAllSalaryRecords(String userguid);

    @Select("select * from SalaryRecord where yearmonth=#{yearmonth} and userguid=#{userguid}")
    SalaryRecord findOneSalaryRecordByYear(String yearmonth, String userguid);

    @Update("update SalaryRecord set companyname=#{companyname}, jobnumber=#{jobnumber}, username=#{username}, department=#{department}, yearmonth=#{yearmonth}, entrydate=#{entrydate}, jobtitle=#{jobtitle}, jobclassification=#{jobclassification}, providentfundnum=#{providentfundnum}, socialsecuritynum=#{socialsecuritynum}, jobrank=#{jobrank}, jobranksalary=#{jobranksalary}, floatingbonus=#{floatingbonus}, holidaysalary=#{holidaysalary}, totalcurrentincome=#{totalcurrentincome}, housingfund=#{housingfund}, medicalinsurance=#{medicalinsurance}, pensioninsurance=#{pensioninsurance}, unemploymentinsurance=#{unemploymentinsurance}, cumulativeincome=#{cumulativeincome}, cumulativespecialdeduction=#{cumulativespecialdeduction}, cumulativedeductions=#{cumulativedeductions}, cumulativetaxableincome=#{cumulativetaxableincome}, cumulativetaxwithholding=#{cumulativetaxwithholding}, cumulativeprepaidtax=#{cumulativeprepaidtax}, totalshouldgetsalary=#{totalshouldgetsalary}, currenttaxpayable=#{currenttaxpayable}, smountactuallysalary=#{smountactuallysalary} where rowguid = #{rowguid}")
    int updateSalaryRecord(SalaryRecord salaryRecord);
}
