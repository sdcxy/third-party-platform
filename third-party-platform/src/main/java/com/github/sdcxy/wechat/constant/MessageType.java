package com.github.sdcxy.wechat.constant;

import lombok.Getter;

@Getter
public enum MessageType {
    /**
     *  消息类型
     */
    text,
    image,
    voice,
    video,
    shortvideo,
    location,
    link,
    event;
}
