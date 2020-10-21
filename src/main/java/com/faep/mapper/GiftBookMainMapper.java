package com.faep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.faep.entity.GiftBookMain;

/**
 * 描述： 礼簿主体表Mapper
 * 作者： Faep
 * 创建时间： 2020-10-21 11:13
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
@Mapper
public interface GiftBookMainMapper
{

    /**
     * 新增一个礼簿主体
     * 
     * @param bookMain
     * @return
     */
    @Insert("insert into GiftBookMain values (#{bookguid}, #{bookname}, #{occurdate}, #{remark})")
    int addNewGiftBookMain(GiftBookMain bookMain);

    /**
     * 查询所有礼簿
     * 
     * @return
     */
    @Select("select * from GiftBookMain order by occurdate")
    List<GiftBookMain> findAllGiftBookMain();

    /**
     * 更新
     * 
     * @param bookMain
     * @return
     */
    @Update("update GiftBookMain set bookname=#{bookname}, occurdate=#{occurdate}, remark=#{remark} where bookguid=#{bookguid}")
    int updateGiftBookMain(GiftBookMain bookMain);

}
