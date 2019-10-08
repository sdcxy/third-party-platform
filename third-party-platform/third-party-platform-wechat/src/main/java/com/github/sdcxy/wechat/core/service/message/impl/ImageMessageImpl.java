package com.github.sdcxy.wechat.core.service.message.impl;

import com.github.sdcxy.wechat.core.entity.message.req.ImageMessage;
import com.github.sdcxy.wechat.core.service.message.Image;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName ImageMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 8:31
 **/
@Service
public class ImageMessageImpl implements Image {
    @Override
    public String parseImageMessage(ImageMessage imageMessage) {
        return MessageUtils.parseDefaultMessage(imageMessage);
    }
}
