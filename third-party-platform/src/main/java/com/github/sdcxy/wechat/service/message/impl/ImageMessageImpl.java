package com.github.sdcxy.wechat.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.ParseXmlUtils;
import com.github.sdcxy.wechat.entity.message.receive.ImageMessage;
import com.github.sdcxy.wechat.entity.message.response.RespImageMessage;
import com.github.sdcxy.wechat.entity.message.response.message.RespImage;
import com.github.sdcxy.wechat.service.message.Image;

/**
 * @ClassName ImageMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 17:48
 **/
public class ImageMessageImpl implements Image {
    @Override
    public String parseImageMessage(ImageMessage imageMessage) {
        // 获取互换后的发送者和接收者
        String ToUserName = imageMessage.getFromUserName();
        String FromUserName = imageMessage.getToUserName();
        // 转换成响应信息类
        RespImageMessage respImageMessage = JSON.parseObject(JSON.toJSONString(imageMessage),RespImageMessage.class);

        // 发送者与接收者互换
        respImageMessage.setFromUserName(FromUserName);
        respImageMessage.setToUserName(ToUserName);

        //设置响应的图片id
        RespImage respImage = new RespImage();
        respImage.setMediaId(imageMessage.getMediaId());
        respImageMessage.setImage(respImage);
        //返回xml信息
        String xml = ParseXmlUtils.beanToXml(respImageMessage);
        System.out.println(xml);
        return xml;
    }
}
