package com.github.sdcxy.wechat.service.message;

import com.github.sdcxy.wechat.entity.message.receive.ImageMessage;

public interface Image {
    String parseImageMessage(ImageMessage imageMessage);
}
