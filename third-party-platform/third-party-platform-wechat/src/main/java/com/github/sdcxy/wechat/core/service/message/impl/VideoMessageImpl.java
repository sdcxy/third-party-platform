package com.github.sdcxy.wechat.core.service.message.impl;

import com.github.sdcxy.wechat.core.entity.message.req.VideoMessage;
import com.github.sdcxy.wechat.core.service.message.Video;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName VideoMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 19:03
 **/
@Service
public class VideoMessageImpl implements Video {
    @Override
    public String parseVideoMessage(VideoMessage videoMessage) {
        return MessageUtils.parseDefaultMessage(videoMessage);
    }
}
