package com.github.sdcxy.wechat.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.wechat.core.constants.Constants;
import com.github.sdcxy.wechat.core.constants.EventType;
import com.github.sdcxy.wechat.core.entity.message.event.*;
import com.github.sdcxy.wechat.core.entity.message.req.*;
import com.github.sdcxy.wechat.core.service.MessageService;
import com.github.sdcxy.wechat.core.service.message.*;
import com.github.sdcxy.wechat.core.service.message.Location;
import com.github.sdcxy.wechat.core.service.message.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 1:24
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private Text textService;

    @Autowired
    private Image imageService;

    @Autowired
    private Voice voiceService;

    @Autowired
    private Video videoService;

    @Autowired
    private Location locationService;

    @Autowired
    private Link linkService;

    @Autowired
    private Subscribe subscribeService;

    @Autowired
    private UnSubscribe unSubscribeService;

    @Autowired
    private Scan scanService;

    @Autowired
    private ClickMenu clickMenuService;

    @Autowired
    private ViewMenu viewMenuService;

    @Autowired
    private com.github.sdcxy.wechat.core.service.message.event.Location locationEventService;



    @Override
    public String parseMessage(Map<String, Object> map) {
        String resultStr = null;
        // 消息处理
        String MsgType = map.get(Constants.MSGTYPE) + "";

        if (MsgType.equals(com.github.sdcxy.wechat.core.constants.MsgType.TEXT)) {
            //文本消息处理
            TextMessage textMessage = JSON.parseObject(JSON.toJSONString(map),TextMessage.class);
            resultStr  =  textService.parseTextMessage(textMessage);
        }
        if (MsgType.equals(com.github.sdcxy.wechat.core.constants.MsgType.IMAGE)) {
            //图片消息处理
            ImageMessage imageMessage = JSON.parseObject(JSON.toJSONString(map),ImageMessage.class);
            resultStr =  imageService.parseImageMessage(imageMessage);
        }
        if (MsgType.equals(com.github.sdcxy.wechat.core.constants.MsgType.VOICE)) {
            //语音消息处理
            VoiceMessage voiceMessage = JSON.parseObject(JSON.toJSONString(map),VoiceMessage.class);
            resultStr = voiceService.parseVoiceMessage(voiceMessage);
        }
        if (MsgType.equals(com.github.sdcxy.wechat.core.constants.MsgType.VIDEO)) {
            // 视频消息处理
            VideoMessage videoMessage = JSON.parseObject(JSON.toJSONString(map),VideoMessage.class);
            resultStr =  videoService.parseVideoMessage(videoMessage);
        }
        if (MsgType.equals(com.github.sdcxy.wechat.core.constants.MsgType.SHORT_VIDEO)) {
            // 短视频消息处理
            VideoMessage videoMessage = JSON.parseObject(JSON.toJSONString(map),VideoMessage.class);
            resultStr =  videoService.parseVideoMessage(videoMessage);
        }
        if (MsgType.equals(com.github.sdcxy.wechat.core.constants.MsgType.LOCATION)) {
            // 地理信息处理
            LocationMessage locationMessage = JSON.parseObject(JSON.toJSONString(map),LocationMessage.class);
            resultStr =  locationService.parseLocationMessage(locationMessage);
        }
        if (MsgType.equals(com.github.sdcxy.wechat.core.constants.MsgType.LINK)) {
            // 链接信息处理
            LinkMessage linkMessage = JSON.parseObject(JSON.toJSONString(map),LinkMessage.class);
            resultStr =  linkService.parseLinkMessage(linkMessage);
        }
        if (MsgType.equals(com.github.sdcxy.wechat.core.constants.MsgType.EVENT)) {
            // 获取事件类型
            String event = map.get(Constants.EVENT) + "";
            if (event.equals(EventType.SUBSCRIBE)) {
                //订阅消息处理
                SubscribeEvent subscribeEvent = JSON.parseObject(JSON.toJSONString(map),SubscribeEvent.class);
                resultStr =  subscribeService.parseSubscribeEvent(subscribeEvent);
            }
            if (event.equals(EventType.UNSUBSCRIBE)) {
                //取消订阅消息处理
                UnSubscribeEvent unSubscribeEvent = JSON.parseObject(JSON.toJSONString(map),UnSubscribeEvent.class);
                resultStr = unSubscribeService.parseUnSubscribeEvent(unSubscribeEvent);
            }
            if (event.equals(EventType.SCAN)) {
                //扫描事件处理
                ScanEvent scanEvent = JSON.parseObject(JSON.toJSONString(map),ScanEvent.class);
                resultStr = scanService.parseScanEvent(scanEvent);
            }
            if (event.equals(EventType.LOCATION)) {
                //地理信息事件处理
                LocationEvent locationEvent = JSON.parseObject(JSON.toJSONString(map),LocationEvent.class);
                resultStr = locationEventService.parseLocationEvent(locationEvent);
            }
            if (event.equals(EventType.CLICK)) {
                //点击菜单事件处理
                ClickMenuEvent clickMenuEvent = JSON.parseObject(JSON.toJSONString(map),ClickMenuEvent.class);
                resultStr = clickMenuService.parseClickMenuEvent(clickMenuEvent);
            }
            if (event.equals(EventType.VIEW)) {
                //View菜单事件处理
                ViewMenuEvent viewMenuEvent = JSON.parseObject(JSON.toJSONString(map),ViewMenuEvent.class);
                resultStr = viewMenuService.parseViewMenuEvent(viewMenuEvent);
            }
        }
        return resultStr;
    }
}
