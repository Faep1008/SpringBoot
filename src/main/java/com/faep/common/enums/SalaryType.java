package com.faep.common.enums;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/6/30 14:21
 * 版本： [1.0, 2020/6/30]
 * 版权： Faep
 */
public enum SalaryType {
    收入("1"), 支出("2");
    String type;

    SalaryType(String type) {
        this.type = type;
    }

    public String getValue() {
        return type;
    }
}
