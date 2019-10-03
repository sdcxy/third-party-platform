package com.github.sdcxy.wechat.service.message;

import com.github.sdcxy.wechat.entity.message.receive.VoiceMessage;

public interface Voice {
    String parseVoiceMessage(VoiceMessage voiceMessage);
}
