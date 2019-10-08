package com.github.sdcxy.wechat.core.service.message.impl;

import com.github.sdcxy.wechat.core.entity.message.req.VoiceMessage;
import com.github.sdcxy.wechat.core.service.message.Voice;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName VoiceMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 18:53
 **/
@Service
public class VoiceMessageImpl implements Voice {

    @Override
    public String parseVoiceMessage(VoiceMessage voiceMessage) {
        return MessageUtils.parseDefaultMessage(voiceMessage);
    }
}
