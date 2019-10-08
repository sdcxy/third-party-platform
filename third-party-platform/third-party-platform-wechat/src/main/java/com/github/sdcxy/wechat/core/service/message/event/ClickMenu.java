package com.github.sdcxy.wechat.core.service.message.event;


import com.github.sdcxy.wechat.core.entity.message.event.ClickMenuEvent;

public interface ClickMenu {
    String parseClickMenuEvent(ClickMenuEvent clickMenuEvent);
}
