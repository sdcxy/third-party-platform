package com.github.sdcxy.wechat.service.message.event.impl;

import com.github.sdcxy.wechat.entity.message.event.ViewMenuEvent;
import com.github.sdcxy.wechat.service.message.event.ViewMenu;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName ViewMenuEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:37
 **/
public class ViewMenuEventImpl implements ViewMenu {
    @Override
    public String parseViewMenuEvent(ViewMenuEvent viewMenuEvent) {
        // 获取互换后的发送者和接收者
        String ToUserName = viewMenuEvent.getFromUserName();
        String FromUserName = viewMenuEvent.getToUserName();

        return MessageUtils.replyTextMessage(FromUserName,ToUserName,viewMenuEvent);
    }
}
