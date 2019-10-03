package com.github.sdcxy.wechat.service.message;

import com.github.sdcxy.wechat.entity.message.receive.LocationMessage;

public interface Location {
    String parseLocationMessage(LocationMessage locationMessage);
}
