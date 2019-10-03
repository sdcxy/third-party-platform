package com.github.sdcxy.wechat.entity.message.receive;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName VoiceMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 10:09
 **/
@Data
public class VoiceMessage  extends BaseMessage {

    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String MediaId;

    /**
     * 语音格式，如amr，speex等
     */
    private String Format;

    /**
     * 语音识别结果，UTF8编码
     */
    private String Recognition;
}
