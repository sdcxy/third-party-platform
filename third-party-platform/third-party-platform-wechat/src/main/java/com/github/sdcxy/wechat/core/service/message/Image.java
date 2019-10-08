package com.github.sdcxy.wechat.core.service.message;

import com.github.sdcxy.wechat.core.entity.message.req.ImageMessage;

public interface Image {
    String parseImageMessage(ImageMessage imageMessage);
}
