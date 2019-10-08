package com.github.sdcxy.wechat.core.entity.message.resp;

import com.github.sdcxy.wechat.core.entity.message.BaseMessage;
import com.github.sdcxy.wechat.core.entity.message.resp.sub.RespVideo;
import lombok.Data;

/**
 * @ClassName RespVideoMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:12
 **/
@Data
public class RespVideoMessage extends BaseMessage {
    /**
     * 设置视频消息
     */
    private RespVideo Video;
}
