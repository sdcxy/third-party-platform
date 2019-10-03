package com.github.sdcxy.wechat.service.message.event;

import com.github.sdcxy.wechat.entity.message.event.ViewMenuEvent;

public interface ViewMenu {
    String parseViewMenuEvent(ViewMenuEvent viewMenuEvent);
}
