package com.faep.service.api;

import java.util.List;

import com.faep.entity.GiftBookItem;

/**
 * 描述： 礼簿具体项Service接口
 * 作者： Faep
 * 创建时间： 2020-10-21 11:27
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
public interface IGiftBookItemService
{
    /**
     * 新增
     *
     * @param bookItem
     * @return
     */
    int addNewGiftBookItem(GiftBookItem bookItem);

    /**
     * 查询
     *
     * @param bookguid
     * @param username
     * @return
     */
    List<GiftBookItem> findGiftItemByUserName(GiftBookItem bookItem);

    /**
     * 更新
     *
     * @param bookItem
     * @return
     */
    int updateGiftItem(GiftBookItem bookItem);
}
