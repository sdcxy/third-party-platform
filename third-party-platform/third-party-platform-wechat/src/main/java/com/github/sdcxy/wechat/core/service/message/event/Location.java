package com.github.sdcxy.wechat.core.service.message.event;


import com.github.sdcxy.wechat.core.entity.message.event.LocationEvent;

public interface Location {
    String parseLocationEvent(LocationEvent locationEvent);
}
