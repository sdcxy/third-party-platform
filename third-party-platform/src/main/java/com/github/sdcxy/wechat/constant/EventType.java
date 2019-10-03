package com.github.sdcxy.wechat.constant;

import lombok.Getter;

/**
 * @ClassName EventType
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 9:36
 **/
@Getter
public enum  EventType {
    subscribe,
    unsubscribe,
    SCAN,
    LOCATION,
    CLICK,
    VIEW;
}
