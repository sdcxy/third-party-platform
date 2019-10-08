package com.github.sdcxy.wechat.core.service.message;

import com.github.sdcxy.wechat.core.entity.message.req.VoiceMessage;

public interface Voice {

    String parseVoiceMessage(VoiceMessage voiceMessage);
}
