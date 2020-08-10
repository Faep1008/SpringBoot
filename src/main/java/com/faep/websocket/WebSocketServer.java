package com.faep.websocket;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;
import javax.inject.Named;

import org.atmosphere.config.service.*;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.Broadcaster;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 描述： WebSocket的处理类，这个类里监听连接的建立关闭、消息的接收等
 * 作者： Faep
 * 创建时间： 2020/7/23 10:08
 * 版本： [1.0, 2020/7/23]
 * 版权： Faep
 */
@ManagedService(path = "/websocket/test/{biaoduan}", atmosphereConfig = {
        "org.atmosphere.cpr.CometSupport.maxInactiveActivity=120000" }, broadcastFilters = {MessageFilter.class })
public class WebSocketServer
{
    /**
     * 注入连接信息，对象中保存了连接的基本信息，可以用于获取发起连接时传入的参数(r.getRequest().getHeader("uid")))
     */
    @Inject
    private AtmosphereResource r;

    @PathParam("biaoduan")
    private String biaoduan;

    /**
     * 注入broadcaster组件，这个对象可以用来发送广播消息，API:broadcaster.broadcast(json)，
     * 会往所有用户推送一条消息。对外开放的api可以单独写个public方法来实现，方法内部调用这个私有变量。
     */
    @Inject
    @PathParam("biaoduan")
    @Named("/websocket/test/{biaoduan}")
    private static Broadcaster broadcaster;

    /**
     * 建立websocket连接时触发
     */
    @Ready
    public void onReady() {
        System.out.println("进入onReady。。。biaoduan = " +biaoduan );
    }

    /**
     * 断开websocket连接时触发
     *
     * @param event
     */
    @Disconnect
    public void onDisconnect(AtmosphereResourceEvent event) {
    }

    /**
     * 接收到消息时触发
     *
     * @param data
     *            接收到的数据
     * @throws IOException
     */
    @Message(decoders = {MessageReceiveDecoder.class })
    public void onMessage(String data) throws IOException {
        System.out.println(data);
    }

    /**
     * 心跳方法，定时触发，web.xml可以修改频率
     */
    @Heartbeat
    public void onHeartbeat(AtmosphereResourceEvent event) {
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "  进入onHeartbeat。。。");
    }

    /**
     *
     * 广播消息
     *
     * @param json
     */
    public static void broadcast(String json) {
        if (broadcaster != null) {
            try {
                broadcaster.broadcast(json);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
