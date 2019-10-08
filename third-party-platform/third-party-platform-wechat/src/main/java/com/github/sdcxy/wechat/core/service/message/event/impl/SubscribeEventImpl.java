package com.github.sdcxy.wechat.core.service.message.event.impl;

import com.github.sdcxy.wechat.core.entity.message.event.SubscribeEvent;
import com.github.sdcxy.wechat.core.service.message.event.Subscribe;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName SubscribeEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:34
 **/
@Service
public class SubscribeEventImpl implements Subscribe {

    @Override
    public String parseSubscribeEvent(SubscribeEvent subscribeEvent) {
        return MessageUtils.parseDefaultMessage(subscribeEvent);
    }
}
