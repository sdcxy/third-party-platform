package com.github.sdcxy.wechat.service.message.event;

import com.github.sdcxy.wechat.entity.message.event.ClickMenuEvent;

public interface ClickMenu {
    String parseClickMenuEvent(ClickMenuEvent clickMenuEvent);
}
