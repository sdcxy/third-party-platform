package com.github.sdcxy.wechat.core.service.message;

import com.github.sdcxy.wechat.core.entity.message.req.VideoMessage;

public interface Video {
    String parseVideoMessage(VideoMessage videoMessage);
}
