package com.github.sdcxy.wechat.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.ParseXmlUtils;
import com.github.sdcxy.wechat.constant.MessageType;
import com.github.sdcxy.wechat.entity.message.receive.LocationMessage;
import com.github.sdcxy.wechat.entity.message.response.RespTextMessage;
import com.github.sdcxy.wechat.service.message.Location;

/**
 * @ClassName LocationMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 17:58
 **/
public class LocationMessageImpl implements Location {
    @Override
    public String parseLocationMessage(LocationMessage locationMessage) {
        // 获取互换后的发送者和接收者
        String ToUserName = locationMessage.getFromUserName();
        String FromUserName = locationMessage.getToUserName();

        RespTextMessage respTextMessage = JSON.parseObject(JSON.toJSONString(locationMessage), RespTextMessage.class);
        respTextMessage.setFromUserName(FromUserName);
        respTextMessage.setToUserName(ToUserName);
        respTextMessage.setMsgType(MessageType.text.toString());
        respTextMessage.setContent(locationMessage.getLabel());

        //返回xml信息
        String xml = ParseXmlUtils.beanToXml(respTextMessage);
        System.out.println(xml);
        return xml;
    }
}
