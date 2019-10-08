package com.github.sdcxy.wechat.core.entity.message.event;

import com.github.sdcxy.wechat.core.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName ViewMenuEvent
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 9:15
 **/
@Data
public class ViewMenuEvent extends BaseMessage {

    /**
     * 事件类型，VIEW
     */
    private String Event = "VIEW";

    /**
     * 事件KEY值，设置的跳转URL
     */
    private String EventKey;
}
