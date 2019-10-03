package com.github.sdcxy.wechat.service.message.event.impl;

import com.github.sdcxy.wechat.entity.message.event.LocationEvent;
import com.github.sdcxy.wechat.service.message.event.Location;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName LocationEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:35
 **/
public class LocationEventImpl implements Location {
    @Override
    public String parseLocationEvent(LocationEvent locationEvent) {

        // 获取互换后的发送者和接收者
        String ToUserName = locationEvent.getFromUserName();
        String FromUserName = locationEvent.getToUserName();

        return MessageUtils.replyTextMessage(FromUserName,ToUserName,locationEvent);
    }
}
