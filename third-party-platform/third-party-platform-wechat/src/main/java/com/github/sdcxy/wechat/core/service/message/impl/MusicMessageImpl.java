package com.github.sdcxy.wechat.core.service.message.impl;

import com.github.sdcxy.wechat.core.service.message.Music;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName MusicMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 19:04
 **/
@Service
public class MusicMessageImpl implements Music {

    @Override
    public String parseMusicMessage(Object object) {
        return MessageUtils.parseDefaultMessage(object);
    }
}
