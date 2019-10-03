package com.github.sdcxy.wechat.service.message.event;

import com.github.sdcxy.wechat.entity.message.event.SubscribeEvent;

public interface Subscribe {
    String parseSubscribeEvent(SubscribeEvent subscribeEvent);
}
