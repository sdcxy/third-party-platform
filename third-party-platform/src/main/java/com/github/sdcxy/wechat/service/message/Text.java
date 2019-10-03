package com.github.sdcxy.wechat.service.message;

import com.github.sdcxy.wechat.entity.message.receive.TextMessage;

public interface Text {
    String parseTextMessage(TextMessage textMessage);
}
