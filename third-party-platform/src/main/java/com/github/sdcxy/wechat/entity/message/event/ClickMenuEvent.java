package com.github.sdcxy.wechat.entity.message.event;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName ClickMenuEvent
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 9:14
 **/
@Data
public class ClickMenuEvent extends BaseMessage {

    /**
     * 事件类型，CLICK
     */
    private String Event = "CLICK";

    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    private String EventKey;
}
