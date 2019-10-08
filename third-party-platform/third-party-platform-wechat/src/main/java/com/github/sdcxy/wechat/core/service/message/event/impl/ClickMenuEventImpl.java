package com.github.sdcxy.wechat.core.service.message.event.impl;


import com.github.sdcxy.wechat.core.entity.message.event.ClickMenuEvent;
import com.github.sdcxy.wechat.core.service.message.event.ClickMenu;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName ClickMenuEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:37
 **/
@Service
public class ClickMenuEventImpl implements ClickMenu {
    @Override
    public String parseClickMenuEvent(ClickMenuEvent clickMenuEvent) {
        return MessageUtils.parseDefaultMessage(clickMenuEvent);
    }
}
