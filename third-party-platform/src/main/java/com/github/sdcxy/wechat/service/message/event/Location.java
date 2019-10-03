package com.github.sdcxy.wechat.service.message.event;

import com.github.sdcxy.wechat.entity.message.event.LocationEvent;

public interface Location {
    String parseLocationEvent(LocationEvent locationEvent);
}
