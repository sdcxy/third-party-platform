package com.github.sdcxy.wechat.core.service.message;

import com.github.sdcxy.wechat.core.entity.message.req.TextMessage;

public interface Text {
    String  parseTextMessage(TextMessage textMessage);
}
