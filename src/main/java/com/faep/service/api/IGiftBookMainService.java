package com.faep.service.api;

import java.util.List;

import com.faep.entity.GiftBookMain;

/**
 * 描述： 礼簿主体Service接口
 * 作者： Faep
 * 创建时间： 2020-10-21 11:27
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
public interface IGiftBookMainService
{
    /**
     * 新增一个礼簿主体
     *
     * @param bookMain
     * @return
     */
    int addNewGiftBookMain(GiftBookMain bookMain);

    /**
     * 查询所有礼簿
     *
     * @return
     */
    List<GiftBookMain> findAllGiftBookMain();

    /**
     * 更新
     *
     * @param bookMain
     * @return
     */
    int updateGiftBookMain(GiftBookMain bookMain);
}
