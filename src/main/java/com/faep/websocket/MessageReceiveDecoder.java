package com.faep.websocket;


import java.io.IOException;
import org.atmosphere.config.managed.Decoder;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 描述： [编写数据转换器]
 * 作者： Faep
 * 创建时间： 2020/7/23 10:51
 * 版本： [1.0, 2020/7/23]
 * 版权： Faep
 */
public class MessageReceiveDecoder implements Decoder<String, MessageReceive>
{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public MessageReceive decode(String s) {
        try {
            return mapper.readValue(s, MessageReceive.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

