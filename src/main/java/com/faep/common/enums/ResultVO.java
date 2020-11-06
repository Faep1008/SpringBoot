package com.faep.common.enums;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/6/30 14:23
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
public enum ResultVO {
    SUCCESS("OK"), ERROR("Error");
    String status;

    ResultVO(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }
}
