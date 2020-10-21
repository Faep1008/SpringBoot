package com.faep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faep.entity.GiftBookMain;
import com.faep.mapper.GiftBookMainMapper;
import com.faep.service.api.IGiftBookMainService;

/**
 * 描述： 礼簿主体Service实现类
 * 作者： Faep
 * 创建时间： 2020-10-21 11:29
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
@Service
public class GiftBookMainService implements IGiftBookMainService
{

    @Autowired
    @SuppressWarnings("all")
    GiftBookMainMapper giftBookMainMapper;

    @Override
    public int addNewGiftBookMain(GiftBookMain bookMain) {
        return giftBookMainMapper.addNewGiftBookMain(bookMain);
    }

    @Override
    public List<GiftBookMain> findAllGiftBookMain() {
        return giftBookMainMapper.findAllGiftBookMain();
    }

    @Override
    public int updateGiftBookMain(GiftBookMain bookMain) {
        return giftBookMainMapper.updateGiftBookMain(bookMain);
    }
}
