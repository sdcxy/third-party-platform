package com.github.sdcxy.wechat.service.message.event.impl;

import com.github.sdcxy.wechat.entity.message.event.ClickMenuEvent;
import com.github.sdcxy.wechat.service.message.event.ClickMenu;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName ClickMenuEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:37
 **/
public class ClickMenuEventImpl implements ClickMenu {
    @Override
    public String parseClickMenuEvent(ClickMenuEvent clickMenuEvent) {
        // 获取互换后的发送者和接收者
        String ToUserName = clickMenuEvent.getFromUserName();
        String FromUserName = clickMenuEvent.getToUserName();

        return MessageUtils.replyTextMessage(FromUserName,ToUserName,clickMenuEvent);
    }
}
