package com.github.sdcxy.wechat.service.message;

import com.github.sdcxy.wechat.entity.message.receive.VideoMessage;

public interface ShortVideo {
    String parseShortVideoMessage(VideoMessage videoMessage);
}
