package com.github.sdcxy.wechat.core.service.message;

import com.github.sdcxy.wechat.core.entity.message.req.LocationMessage;

public interface Location {
    String parseLocationMessage(LocationMessage locationMessage);
}
