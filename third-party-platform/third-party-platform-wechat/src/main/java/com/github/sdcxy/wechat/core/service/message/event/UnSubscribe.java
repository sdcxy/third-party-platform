package com.github.sdcxy.wechat.core.service.message.event;

import com.github.sdcxy.wechat.core.entity.message.event.UnSubscribeEvent;

public interface UnSubscribe {
    String parseUnSubscribeEvent(UnSubscribeEvent unSubscribeEvent);
}
