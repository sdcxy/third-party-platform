package com.github.sdcxy.wechat.entity.message.response;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import com.github.sdcxy.wechat.entity.message.response.message.RespMusic;
import lombok.Data;

/**
 * @ClassName RespMusicMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:13
 **/
@Data
public class RespMusicMessage extends BaseMessage {
    /**
     * 设置音乐消息
     */
    private RespMusic Music;
}
