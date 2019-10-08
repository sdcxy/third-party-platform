package com.github.sdcxy.wechat.core.service.message.event.impl;

import com.github.sdcxy.wechat.core.entity.message.event.ViewMenuEvent;
import com.github.sdcxy.wechat.core.service.message.event.ViewMenu;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName ViewMenuEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:37
 **/
@Service
public class ViewMenuEventImpl implements ViewMenu {
    @Override
    public String parseViewMenuEvent(ViewMenuEvent viewMenuEvent) {
        return MessageUtils.parseDefaultMessage(viewMenuEvent);
    }
}
