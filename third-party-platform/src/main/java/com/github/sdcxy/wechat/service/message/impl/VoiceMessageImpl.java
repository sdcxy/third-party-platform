package com.github.sdcxy.wechat.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.ParseXmlUtils;
import com.github.sdcxy.wechat.entity.message.receive.VoiceMessage;
import com.github.sdcxy.wechat.entity.message.response.RespVoiceMessage;
import com.github.sdcxy.wechat.entity.message.response.message.RespVoice;
import com.github.sdcxy.wechat.service.message.Voice;

/**
 * @ClassName VoiceMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 17:57
 **/
public class VoiceMessageImpl implements Voice {
    @Override
    public String parseVoiceMessage(VoiceMessage voiceMessage) {
        // 获取互换后的发送者和接收者
        String ToUserName = voiceMessage.getFromUserName();
        String FromUserName = voiceMessage.getToUserName();
        // 转换成响应信息类
        RespVoiceMessage respVoiceMessage = JSON.parseObject(JSON.toJSONString(voiceMessage),RespVoiceMessage.class);

        // 发送者与接收者互换
        respVoiceMessage.setFromUserName(FromUserName);
        respVoiceMessage.setToUserName(ToUserName);

        //设置响应的图片id
        RespVoice respVoice = new RespVoice();
        respVoice.setMediaId(voiceMessage.getMediaId());
        respVoiceMessage.setVoice(respVoice);
        //返回xml信息
        String xml = ParseXmlUtils.beanToXml(respVoiceMessage);
        System.out.println(xml);
        return xml;
    }
}
