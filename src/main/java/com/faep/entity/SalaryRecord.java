package com.faep.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述： 工资记录实体
 * 作者： Faep
 * 创建时间： 2020-11-06 16:17
 * 版本： [1.0, 2020-11-06]
 * 版权： Faep
 */
public class SalaryRecord
{

    /**
     * 唯一标识
     */
    private String rowguid;
    /**
     * 公司名称
     */
    private String companyname;
    /**
     * 工号
     */
    private String jobnumber;
    /**
     * 姓名
     */
    private String username;
    /**
     * 部门
     */
    private String department;
    /**
     * 发工资年月
     */
    private String yearmonth;
    /**
     * 入职时间
     */
    private Date entrydate;
    /**
     * 职务名称
     */
    private String jobtitle;
    /**
     * 岗位分类
     */
    private String jobclassification;
    /**
     * 公积金号码
     */
    private String providentfundnum;
    /**
     * 社会保障号码
     */
    private String socialsecuritynum;
    /**
     * 职级
     */
    private String jobrank;
    /**
     * 职级工资
     */
    private BigDecimal jobranksalary;
    /**
     * 浮动奖金
     */
    private BigDecimal floatingbonus;
    /**
     * 过节费
     */
    private BigDecimal holidaysalary;
    /**
     * 本期收入合计
     */
    private BigDecimal totalcurrentincome;
    /**
     * 住房公积金
     */
    private BigDecimal housingfund;
    /**
     * 医疗险
     */
    private BigDecimal medicalinsurance;
    /**
     * 养老险
     */
    private BigDecimal pensioninsurance;
    /**
     * 失业险
     */
    private BigDecimal unemploymentinsurance;
    /**
     * 累计收入额
     */
    private BigDecimal cumulativeincome;
    /**
     * 累计专项扣除
     */
    private BigDecimal cumulativespecialdeduction;
    /**
     * 累计减除费用
     */
    private BigDecimal cumulativedeductions;
    /**
     * 累计应纳税所得额
     */
    private BigDecimal cumulativetaxableincome;
    /**
     * 累计应扣缴税额
     */
    private BigDecimal cumulativetaxwithholding;
    /**
     * 累计已预缴税额
     */
    private BigDecimal cumulativeprepaidtax;
    /**
     * 本期应发合计
     */
    private BigDecimal totalshouldgetsalary;
    /**
     * 本期应缴税额
     */
    private BigDecimal currenttaxpayable;
    /**
     * 本期实发金额
     */
    private BigDecimal smountactuallysalary;

    public SalaryRecord() {
    }

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getJobclassification() {
        return jobclassification;
    }

    public void setJobclassification(String jobclassification) {
        this.jobclassification = jobclassification;
    }

    public String getProvidentfundnum() {
        return providentfundnum;
    }

    public void setProvidentfundnum(String providentfundnum) {
        this.providentfundnum = providentfundnum;
    }

    public String getSocialsecuritynum() {
        return socialsecuritynum;
    }

    public void setSocialsecuritynum(String socialsecuritynum) {
        this.socialsecuritynum = socialsecuritynum;
    }

    public String getJobrank() {
        return jobrank;
    }

    public void setJobrank(String jobrank) {
        this.jobrank = jobrank;
    }

    public BigDecimal getJobranksalary() {
        return jobranksalary;
    }

    public void setJobranksalary(BigDecimal jobranksalary) {
        this.jobranksalary = jobranksalary;
    }

    public BigDecimal getFloatingbonus() {
        return floatingbonus;
    }

    public void setFloatingbonus(BigDecimal floatingbonus) {
        this.floatingbonus = floatingbonus;
    }

    public BigDecimal getHolidaysalary() {
        return holidaysalary;
    }

    public void setHolidaysalary(BigDecimal holidaysalary) {
        this.holidaysalary = holidaysalary;
    }

    public BigDecimal getTotalcurrentincome() {
        return totalcurrentincome;
    }

    public void setTotalcurrentincome(BigDecimal totalcurrentincome) {
        this.totalcurrentincome = totalcurrentincome;
    }

    public BigDecimal getHousingfund() {
        return housingfund;
    }

    public void setHousingfund(BigDecimal housingfund) {
        this.housingfund = housingfund;
    }

    public BigDecimal getMedicalinsurance() {
        return medicalinsurance;
    }

    public void setMedicalinsurance(BigDecimal medicalinsurance) {
        this.medicalinsurance = medicalinsurance;
    }

    public BigDecimal getPensioninsurance() {
        return pensioninsurance;
    }

    public void setPensioninsurance(BigDecimal pensioninsurance) {
        this.pensioninsurance = pensioninsurance;
    }

    public BigDecimal getUnemploymentinsurance() {
        return unemploymentinsurance;
    }

    public void setUnemploymentinsurance(BigDecimal unemploymentinsurance) {
        this.unemploymentinsurance = unemploymentinsurance;
    }

    public BigDecimal getCumulativeincome() {
        return cumulativeincome;
    }

    public void setCumulativeincome(BigDecimal cumulativeincome) {
        this.cumulativeincome = cumulativeincome;
    }

    public BigDecimal getCumulativespecialdeduction() {
        return cumulativespecialdeduction;
    }

    public void setCumulativespecialdeduction(BigDecimal cumulativespecialdeduction) {
        this.cumulativespecialdeduction = cumulativespecialdeduction;
    }

    public BigDecimal getCumulativedeductions() {
        return cumulativedeductions;
    }

    public void setCumulativedeductions(BigDecimal cumulativedeductions) {
        this.cumulativedeductions = cumulativedeductions;
    }

    public BigDecimal getCumulativetaxableincome() {
        return cumulativetaxableincome;
    }

    public void setCumulativetaxableincome(BigDecimal cumulativetaxableincome) {
        this.cumulativetaxableincome = cumulativetaxableincome;
    }

    public BigDecimal getCumulativetaxwithholding() {
        return cumulativetaxwithholding;
    }

    public void setCumulativetaxwithholding(BigDecimal cumulativetaxwithholding) {
        this.cumulativetaxwithholding = cumulativetaxwithholding;
    }

    public BigDecimal getCumulativeprepaidtax() {
        return cumulativeprepaidtax;
    }

    public void setCumulativeprepaidtax(BigDecimal cumulativeprepaidtax) {
        this.cumulativeprepaidtax = cumulativeprepaidtax;
    }

    public BigDecimal getTotalshouldgetsalary() {
        return totalshouldgetsalary;
    }

    public void setTotalshouldgetsalary(BigDecimal totalshouldgetsalary) {
        this.totalshouldgetsalary = totalshouldgetsalary;
    }

    public BigDecimal getCurrenttaxpayable() {
        return currenttaxpayable;
    }

    public void setCurrenttaxpayable(BigDecimal currenttaxpayable) {
        this.currenttaxpayable = currenttaxpayable;
    }

    public BigDecimal getSmountactuallysalary() {
        return smountactuallysalary;
    }

    public void setSmountactuallysalary(BigDecimal smountactuallysalary) {
        this.smountactuallysalary = smountactuallysalary;
    }
}
