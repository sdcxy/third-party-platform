package com.github.sdcxy.wechat.service.message.event;

import com.github.sdcxy.wechat.entity.message.event.UnSubscribeEvent;

public interface UnSubscribe {
    String parseUnSubscribeEvent(UnSubscribeEvent unSubscribeEvent);
}
