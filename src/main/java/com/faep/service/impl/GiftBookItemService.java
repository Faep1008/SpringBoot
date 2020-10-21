package com.faep.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.faep.entity.GiftBookItem;
import com.faep.mapper.GiftBookItemMapper;
import com.faep.service.api.IGiftBookItemService;

/**
 * 描述： 礼簿具体项Service实现类
 * 作者： Faep
 * 创建时间： 2020-10-21 11:28
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
@Service
public class GiftBookItemService implements IGiftBookItemService
{

    @Autowired
    @SuppressWarnings("all")
    GiftBookItemMapper giftBookItemMapper;

    @Override
    public int addNewGiftBookItem(GiftBookItem bookItem) {
        return giftBookItemMapper.addNewGiftBookItem(bookItem);
    }

    @Override
    public List<GiftBookItem> findGiftItemByUserName(GiftBookItem bookItem) {
        if (StringUtils.isEmpty(bookItem.getBookguid())) {
            return new ArrayList<>();
        }
        if (StringUtils.isEmpty(bookItem.getUsername())){
            return giftBookItemMapper.findGiftItemByBookMain(bookItem.getBookguid());
        }
        return giftBookItemMapper.findGiftItemByUserName(bookItem.getBookguid(), bookItem.getUsername());
    }

    @Override
    public int updateGiftItem(GiftBookItem bookItem) {
        return giftBookItemMapper.updateGiftItem(bookItem);
    }
}
