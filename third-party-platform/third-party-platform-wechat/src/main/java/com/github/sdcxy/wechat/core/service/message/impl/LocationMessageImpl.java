package com.github.sdcxy.wechat.core.service.message.impl;

import com.github.sdcxy.wechat.core.entity.message.req.LocationMessage;
import com.github.sdcxy.wechat.core.service.message.Location;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName LocationMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 19:06
 **/
@Service
public class LocationMessageImpl implements Location {
    @Override
    public String parseLocationMessage(LocationMessage locationMessage) {
        return MessageUtils.parseDefaultMessage(locationMessage);
    }
}
