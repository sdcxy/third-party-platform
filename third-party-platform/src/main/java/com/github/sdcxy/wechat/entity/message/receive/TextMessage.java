package com.github.sdcxy.wechat.entity.message.receive;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName TextMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 10:05
 **/
@Data
public class TextMessage extends BaseMessage {
    /**
     * 文本消息内容
     */
    private String Content;
}
