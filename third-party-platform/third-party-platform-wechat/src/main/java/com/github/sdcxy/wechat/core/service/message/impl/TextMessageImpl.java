package com.github.sdcxy.wechat.core.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.wechat.common.util.ParseXmlUtils;
import com.github.sdcxy.wechat.core.entity.message.req.TextMessage;
import com.github.sdcxy.wechat.core.entity.message.resp.RespTextMessage;
import com.github.sdcxy.wechat.core.service.message.Text;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName TextMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 2:22
 **/
@Service
public class TextMessageImpl implements Text {

    @Override
    public String parseTextMessage(TextMessage textMessage) {
        return MessageUtils.parseDefaultMessage(textMessage);
    }
}
