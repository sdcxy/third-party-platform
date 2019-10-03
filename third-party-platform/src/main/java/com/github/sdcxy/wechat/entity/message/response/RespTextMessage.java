package com.github.sdcxy.wechat.entity.message.response;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName RespTextMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:07
 **/
@Data
public class RespTextMessage extends BaseMessage {
    /**
     * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     */
    private String Content;
}
