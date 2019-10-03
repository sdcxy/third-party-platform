package com.github.sdcxy.wechat.service.message;

import com.github.sdcxy.wechat.entity.message.receive.LinkMessage;

public interface Link {
    String parseLinkMessage(LinkMessage linkMessage);
}
