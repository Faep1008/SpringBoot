package com.faep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/23 10:11
 * 版本： [1.0, 2020/7/23]
 * 版权： Faep
 */
@Controller
@RequestMapping("/socket")
public class WebScoketController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testScoket(){
        return "websocket";
    }

}
