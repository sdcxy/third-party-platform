package com.github.sdcxy.wechat.core.service.message.impl;

import com.github.sdcxy.wechat.core.entity.message.req.LinkMessage;
import com.github.sdcxy.wechat.core.service.message.Link;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName LinkMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 22:31
 **/
@Service
public class LinkMessageImpl implements Link {
    @Override
    public String parseLinkMessage(LinkMessage linkMessage) {
        return MessageUtils.parseDefaultMessage(linkMessage);
    }
}
