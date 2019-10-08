package com.github.sdcxy.wechat.core.entity.message.req;

import com.github.sdcxy.wechat.core.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName LinkMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 10:18
 **/
@Data
public class LinkMessage extends BaseMessage {
    /**
    * 消息标题
    */
    private String Title;
    /**
     * 消息描述
     */
    private String Description;
    /**
     *消息链接
     */
    private String Url;
}
