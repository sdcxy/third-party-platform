package com.github.sdcxy.wechat.core.service.message.event.impl;

import com.github.sdcxy.wechat.core.entity.message.event.LocationEvent;
import com.github.sdcxy.wechat.core.service.message.event.Location;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName LocationEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:35
 **/
@Service
public class LocationEventImpl implements Location {
    @Override
    public String parseLocationEvent(LocationEvent locationEvent) {
        return MessageUtils.parseDefaultMessage(locationEvent);
    }
}
