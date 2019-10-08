package com.github.sdcxy.wechat.core.service.message.event;

import com.github.sdcxy.wechat.core.entity.message.event.SubscribeEvent;

/**
 * @ClassName Subscribe
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 22:14
 **/
public interface Subscribe {
    String parseSubscribeEvent(SubscribeEvent subscribeEvent);
}
