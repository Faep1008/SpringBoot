package com.faep.websocket;

/**
 * 描述： [ ]
 * 作者： Faep
 * 创建时间： 2020/7/23 10:51
 * 版本： [1.0, 2020/7/23]
 * 版权： Faep
 */
public class MessageReceive {
    private String from_uid;
    private String from_name;
    private String content;

    public String getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(String from_uid) {
        this.from_uid = from_uid;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
