package com.faep.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述： 日期工具类
 * 作者： Faep
 * 创建时间： 2020-10-20 15:54
 * 版本： [1.0, 2020-10-20]
 * 版权： Faep
 */
public class DateUtils {

    /**
     * 获取当前时间
     * 格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getNowDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
