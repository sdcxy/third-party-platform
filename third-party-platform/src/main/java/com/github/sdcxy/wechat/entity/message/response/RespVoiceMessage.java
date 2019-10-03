package com.github.sdcxy.wechat.entity.message.response;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import com.github.sdcxy.wechat.entity.message.response.message.RespVoice;
import lombok.Data;

/**
 * @ClassName RespVoiceMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:11
 **/
@Data
public class RespVoiceMessage extends BaseMessage {
    /**
     * 设置语音消息
     */
    private RespVoice Voice;
}
