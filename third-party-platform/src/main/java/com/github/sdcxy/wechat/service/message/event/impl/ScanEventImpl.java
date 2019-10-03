package com.github.sdcxy.wechat.service.message.event.impl;

import com.github.sdcxy.wechat.entity.message.event.ScanEvent;
import com.github.sdcxy.wechat.service.message.event.Scan;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName ScanEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:35
 **/
public class ScanEventImpl implements Scan {
    @Override
    public String parseScanEvent(ScanEvent scanEvent) {

        // 获取互换后的发送者和接收者
        String ToUserName = scanEvent.getFromUserName();
        String FromUserName = scanEvent.getToUserName();

        return MessageUtils.replyTextMessage(FromUserName,ToUserName,scanEvent);
    }
}
