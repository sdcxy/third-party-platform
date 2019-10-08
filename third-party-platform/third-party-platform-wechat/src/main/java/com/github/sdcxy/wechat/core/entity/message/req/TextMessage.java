package com.github.sdcxy.wechat.core.entity.message.req;

import com.github.sdcxy.wechat.core.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName RespTextMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 2:15
 **/
@Data
public class TextMessage extends BaseMessage {

    /**
     * 文本消息内容
     */
    private String Content;
}
