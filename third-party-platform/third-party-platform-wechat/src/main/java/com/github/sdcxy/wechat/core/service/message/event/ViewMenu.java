package com.github.sdcxy.wechat.core.service.message.event;

import com.github.sdcxy.wechat.core.entity.message.event.ViewMenuEvent;

public interface ViewMenu {
    String parseViewMenuEvent(ViewMenuEvent viewMenuEvent);
}
