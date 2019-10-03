package com.github.sdcxy.wechat.entity.message.response;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import com.github.sdcxy.wechat.entity.message.response.message.RespImage;
import lombok.Data;

/**
 * @ClassName RespImageMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:10
 **/
@Data
public class RespImageMessage  extends BaseMessage {
    /**
     * 响应的image信息
     */
    private RespImage Image;
}
