package com.github.sdcxy.wechat.core.service.message;

import com.github.sdcxy.wechat.core.entity.message.req.LinkMessage;

public interface Link {
    String parseLinkMessage(LinkMessage linkMessage);
}
