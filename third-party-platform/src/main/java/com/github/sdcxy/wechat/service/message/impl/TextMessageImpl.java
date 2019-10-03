package com.github.sdcxy.wechat.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.ParseXmlUtils;
import com.github.sdcxy.wechat.entity.message.receive.TextMessage;
import com.github.sdcxy.wechat.entity.message.response.RespTextMessage;
import com.github.sdcxy.wechat.service.message.Text;

/**
 * @ClassName TextMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 17:45
 **/
public class TextMessageImpl implements Text {

    @Override
    public String parseTextMessage(TextMessage textMessage) {
        // 获取互换后的发送者和接收者
        String ToUserName = textMessage.getFromUserName();
        String FromUserName = textMessage.getToUserName();
        // 转换成响应信息类
        RespTextMessage respTextMessage = JSON.parseObject(JSON.toJSONString(textMessage),RespTextMessage.class);
        // 发送者与接收者互换
        respTextMessage.setFromUserName(FromUserName);
        respTextMessage.setToUserName(ToUserName);
        //返回xml信息
        String xml = ParseXmlUtils.beanToXml(respTextMessage);
        System.out.println(xml);
        return xml;
    }
}
