package com.github.sdcxy.wechat.service.message.event.impl;

import com.github.sdcxy.wechat.entity.message.event.UnSubscribeEvent;
import com.github.sdcxy.wechat.service.message.event.UnSubscribe;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName UnSubscribeEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:34
 **/
public class UnSubscribeEventImpl implements UnSubscribe {
    @Override
    public String parseUnSubscribeEvent(UnSubscribeEvent unSubscribeEvent) {
        // 获取互换后的发送者和接收者
        String ToUserName = unSubscribeEvent.getFromUserName();
        String FromUserName = unSubscribeEvent.getToUserName();

        return MessageUtils.replyTextMessage(FromUserName,ToUserName,unSubscribeEvent);
    }
}
