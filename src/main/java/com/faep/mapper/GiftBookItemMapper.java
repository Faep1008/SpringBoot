package com.faep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.faep.entity.GiftBookItem;

/**
 * 描述： 礼簿具体项Mapper
 * 作者： Faep
 * 创建时间： 2020-10-21 11:14
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
@Mapper
public interface GiftBookItemMapper
{

    /**
     * 新增
     * 
     * @param bookItem
     * @return
     */
    @Insert("insert into GiftBookItem values (#{itemguid}, #{bookguid}, #{username}, #{money}, #{uppermoney}, #{remark})")
    int addNewGiftBookItem(GiftBookItem bookItem);

    /**
     * 查询
     * 
     * @param bookguid
     * @param username
     * @return
     */
    @Select("SELECT * from GiftBookItem where bookguid=#{bookguid} and username like concat('%',#{username},'%') order by money desc")
    List<GiftBookItem> findGiftItemByUserName(String bookguid, String username);

    /**
     * 查询
     *
     * @param bookguid
     * @param username
     * @return
     */
    @Select("SELECT * from GiftBookItem where bookguid=#{bookguid} order by money desc")
    List<GiftBookItem> findGiftItemByBookMain(String bookguid);

    /**
     * 更新
     * 
     * @param bookItem
     * @return
     */
    @Update("update GiftBookItem set username=#{username}, money=#{money}, uppermoney=#{uppermoney}, remark=#{remark} where itemguid=#{itemguid}")
    int updateGiftItem(GiftBookItem bookItem);

}
