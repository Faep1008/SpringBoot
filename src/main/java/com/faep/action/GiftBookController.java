package com.faep.action;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.faep.common.enums.ResultVO;
import com.faep.common.utils.MoneyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faep.entity.GiftBookItem;
import com.faep.entity.GiftBookMain;
import com.faep.service.api.IGiftBookItemService;
import com.faep.service.api.IGiftBookMainService;

/**
 * 描述： 礼簿后台Action
 * 作者： Faep
 * 创建时间： 2020-10-21 13:50
 * 版本： [1.0, 2020-10-21]
 * 版权： Faep
 */
@RestController
@RequestMapping("/giftbook")
@Scope("request")
public class GiftBookController
{

    @Autowired
    IGiftBookItemService giftBookItemService;
    @Autowired
    IGiftBookMainService giftBookMainService;

    /**
     * 新增礼簿主体
     * 
     * @param bookMain
     * @return
     */
    @PostMapping("/addbookmain")
    public String addNewBookMain(@RequestBody GiftBookMain bookMain) {
        bookMain.setBookguid(UUID.randomUUID().toString());
        giftBookMainService.addNewGiftBookMain(bookMain);
        return ResultVO.SUCCESS.getValue();
    }

    /**
     * 获取所有礼簿主体
     * 
     * @return
     */
    @PostMapping("/findallbookmain")
    public List<GiftBookMain> findAllBookMain() {
        return giftBookMainService.findAllGiftBookMain();
    }

    /**
     * 更新礼簿主体
     * 
     * @param bookMain
     * @return
     */
    @PostMapping("/updatebookmain")
    public String updateBookMain(@RequestBody GiftBookMain bookMain) {
        giftBookMainService.updateGiftBookMain(bookMain);
        return ResultVO.SUCCESS.getValue();
    }

    // **以下是礼簿主体具体项**********************************************************

    /**
     * 新增礼簿具体项
     * 
     * @param bookItem
     * @return
     */
    @PostMapping("/addbookitem")
    public String addNewBookItem(@RequestBody GiftBookItem bookItem) {
        bookItem.setItemguid(UUID.randomUUID().toString());
        bookItem.setUppermoney(MoneyUtils.number2CNMontrayUnit(bookItem.getMoney()));
        giftBookItemService.addNewGiftBookItem(bookItem);
        return ResultVO.SUCCESS.getValue();
    }

    /**
     * 查询礼簿具体项集合
     * 
     * @param bookguid
     * @param username
     * @return
     */
    @PostMapping("/findbookitems")
    public List<GiftBookItem> findAllBookItems(@RequestBody GiftBookItem bookItem) {
        List<GiftBookItem> list = giftBookItemService.findGiftItemByUserName(bookItem);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOrdernum(i + 1);
        }
        return list;
    }

    /**
     * 更新礼簿具体项
     * 
     * @param bookItem
     * @return
     */
    @PostMapping("/updatebookitem")
    public String updateBookItem(@RequestBody GiftBookItem bookItem) {
        bookItem.setUppermoney(MoneyUtils.number2CNMontrayUnit(bookItem.getMoney()));
        giftBookItemService.updateGiftItem(bookItem);
        return ResultVO.SUCCESS.getValue();
    }

    /**
     * 获取礼簿概要信息
     * @param bookguid
     * @return
     */
    @PostMapping("/getgiftbookinfo")
    public String getGiftBookInfo(@RequestBody GiftBookItem bookItem){
        List<GiftBookItem> list = giftBookItemService.findGiftItemByUserName(bookItem);
        BigDecimal allMoney = new BigDecimal(0);
        for (GiftBookItem item : list) {
            allMoney = allMoney.add(item.getMoney());
        }
        return " 总人数：" + list.size() + "， 总金额(￥)：" + allMoney.toPlainString();
    }

}
