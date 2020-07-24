package com.faep.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.faep.websocket.WebSocketServer;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/23 10:11
 * 版本： [1.0, 2020/7/23]
 * 版权： Faep
 */
@RestController
@RequestMapping("/socket2")
public class WebScoketController2 {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void testScoket(){
        Map msg = new HashMap<>();
        msg.put("from_uid", "111");
        msg.put("from_name", "Faep");
        WebSocketServer.broadcast(JSONObject.toJSONString(msg));
    }

}
