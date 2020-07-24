package com.faep.websocket;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.PerRequestBroadcastFilter;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/23 10:52
 * 版本： [1.0, 2020/7/23]
 * 版权： Faep
 */
public class MessageFilter implements PerRequestBroadcastFilter {

    @Override
    public BroadcastAction filter(String broadcasterId, Object originalMessage, Object message) {
        return new BroadcastAction(message);
    }

    @Override
    public BroadcastAction filter(String broadcasterId, AtmosphereResource r, Object originalMessage, Object message) {
        // 由于使用的是broadcaster推送消息，会往每个用户发送数据，在这里过滤掉不需要接受的用户
        // 此处的AtmosphereResource r是接收用户的连接信息，在这里能获取到接收用户的guid(初始化前台传过来的)，在message的json中加了toUserGuid字段
        // 如果两个guid相等标识这条消息需要发送
        String uid = r.getRequest().getHeader("uid");
        if (true) {
                //确定接收此消息
                return new BroadcastAction(BroadcastAction.ACTION.CONTINUE, message);
        }
        // 忽略这条消息
        return new BroadcastAction(BroadcastAction.ACTION.ABORT, message);
    }
}

