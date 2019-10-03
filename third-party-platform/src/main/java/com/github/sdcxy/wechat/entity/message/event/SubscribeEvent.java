package com.github.sdcxy.wechat.entity.message.event;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName SubscribeEvent
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 9:26
 **/
@Data
public class SubscribeEvent extends BaseMessage {

    /**
     * 事件类型，subscribe
     */
    private String Event = "subscribe";

}
