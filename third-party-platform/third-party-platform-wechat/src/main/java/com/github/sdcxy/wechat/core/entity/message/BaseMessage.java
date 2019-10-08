package com.github.sdcxy.wechat.core.entity.message;

import lombok.Data;

/**
 * @ClassName BaseMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 10:03
 **/
@Data
public class BaseMessage {

    /**
     *开发者微信号
     */
    private String ToUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;

    /**
     * 消息创建时间 （整型）
     */
    private long CreateTime;

    /**
     * 消息类型，文本为text 图片为image 语音为voice 视频为video 小视频为shortvideo  地理位置为location 链接为link
     */
    private String MsgType;

    /**
     * 事件类型
     */
    private String Event;

    /**
     * 消息id，64位整型
     */
    private String MsgId;

}
