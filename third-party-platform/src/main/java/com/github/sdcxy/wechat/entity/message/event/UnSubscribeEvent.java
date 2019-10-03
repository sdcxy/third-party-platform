package com.github.sdcxy.wechat.entity.message.event;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName UnSubscribeEvent
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 9:12
 **/
@Data
public class UnSubscribeEvent extends BaseMessage {

    /**
     * 事件类型，unsubscribe
     */
    private String Event = "unsubscribe";
}
