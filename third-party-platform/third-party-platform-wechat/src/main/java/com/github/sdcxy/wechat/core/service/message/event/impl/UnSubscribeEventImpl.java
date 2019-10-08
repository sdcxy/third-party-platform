package com.github.sdcxy.wechat.core.service.message.event.impl;


import com.github.sdcxy.wechat.core.entity.message.event.UnSubscribeEvent;
import com.github.sdcxy.wechat.core.service.message.event.UnSubscribe;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName UnSubscribeEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:34
 **/
@Service
public class UnSubscribeEventImpl implements UnSubscribe {
    @Override
    public String parseUnSubscribeEvent(UnSubscribeEvent unSubscribeEvent) {
        return MessageUtils.parseDefaultMessage(unSubscribeEvent);
    }
}
