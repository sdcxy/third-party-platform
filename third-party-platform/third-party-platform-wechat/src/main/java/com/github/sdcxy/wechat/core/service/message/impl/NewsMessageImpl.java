package com.github.sdcxy.wechat.core.service.message.impl;

import com.github.sdcxy.wechat.core.service.message.News;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName NewsMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 22:10
 **/
@Service
public class NewsMessageImpl implements News {
    @Override
    public String parseNewsMessage(Object object) {
        return MessageUtils.parseDefaultMessage(object);
    }
}
