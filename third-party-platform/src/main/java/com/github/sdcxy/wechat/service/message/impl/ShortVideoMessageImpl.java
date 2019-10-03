package com.github.sdcxy.wechat.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.ParseXmlUtils;
import com.github.sdcxy.wechat.constant.MessageType;
import com.github.sdcxy.wechat.entity.message.receive.VideoMessage;
import com.github.sdcxy.wechat.entity.message.response.RespTextMessage;
import com.github.sdcxy.wechat.service.message.ShortVideo;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName ShortVideoMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 17:57
 **/
public class ShortVideoMessageImpl implements ShortVideo {
    @Override
    public String parseShortVideoMessage(VideoMessage videoMessage) {
        // 获取互换后的发送者和接收者
        String ToUserName = videoMessage.getFromUserName();
        String FromUserName = videoMessage.getToUserName();

        return MessageUtils.replyTextMessage(FromUserName,ToUserName,videoMessage);
    }
}
