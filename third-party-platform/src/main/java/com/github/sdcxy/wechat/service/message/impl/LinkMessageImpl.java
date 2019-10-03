package com.github.sdcxy.wechat.service.message.impl;

import com.github.sdcxy.wechat.entity.message.receive.LinkMessage;
import com.github.sdcxy.wechat.service.message.Link;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName LinkMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 17:58
 **/
public class LinkMessageImpl implements Link {
    @Override
    public String parseLinkMessage(LinkMessage linkMessage) {

        // 获取互换后的发送者和接收者
        String ToUserName = linkMessage.getFromUserName();
        String FromUserName = linkMessage.getToUserName();

        return MessageUtils.replyTextMessage(FromUserName,ToUserName,linkMessage);
    }
}
