package com.github.sdcxy.wechat.service.message.event.impl;

import com.github.sdcxy.wechat.entity.message.event.SubscribeEvent;
import com.github.sdcxy.wechat.service.message.event.Subscribe;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName SubscribeEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:34
 **/
public class SubscribeEventImpl implements Subscribe {

    @Override
    public String parseSubscribeEvent(SubscribeEvent subscribeEvent) {
        // 获取互换后的发送者和接收者
        String ToUserName = subscribeEvent.getFromUserName();
        String FromUserName = subscribeEvent.getToUserName();

        return MessageUtils.replyTextMessage(FromUserName,ToUserName,subscribeEvent);
    }
}
