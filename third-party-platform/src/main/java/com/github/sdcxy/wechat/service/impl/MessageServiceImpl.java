package com.github.sdcxy.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.wechat.constant.EventType;
import com.github.sdcxy.wechat.constant.MessageConstants;
import com.github.sdcxy.wechat.constant.MessageType;
import com.github.sdcxy.wechat.entity.message.event.*;
import com.github.sdcxy.wechat.entity.message.receive.*;
import com.github.sdcxy.wechat.service.MessageService;
import com.github.sdcxy.wechat.service.message.*;
import com.github.sdcxy.wechat.service.message.Location;
import com.github.sdcxy.wechat.service.message.event.*;
import com.github.sdcxy.wechat.service.message.event.impl.*;
import com.github.sdcxy.wechat.service.message.impl.*;

import java.util.Map;

/**
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 16:45
 **/
public class MessageServiceImpl implements MessageService, MessageFactory {

    @Override
    public String parseMessage(Map<String,Object> map) {
        // 消息处理
        String MsgType = map.get(MessageConstants.MsgType.toString()) + "";

        if (MsgType.equals(MessageType.text.toString())) {
            //文本消息处理
            TextMessage textMessage = JSON.parseObject(JSON.toJSONString(map),TextMessage.class);
            return createText().parseTextMessage(textMessage);
        }
        if (MsgType.equals(MessageType.image.toString())) {
            //图片消息处理
            ImageMessage imageMessage = JSON.parseObject(JSON.toJSONString(map),ImageMessage.class);
            return createImage().parseImageMessage(imageMessage);
        }
        if (MsgType.equals(MessageType.voice.toString())) {
            //语音消息处理
            VoiceMessage voiceMessage = JSON.parseObject(JSON.toJSONString(map),VoiceMessage.class);
            return createVoice().parseVoiceMessage(voiceMessage);
        }
        if (MsgType.equals(MessageType.video.toString())) {
            // 视频消息处理
            VideoMessage videoMessage = JSON.parseObject(JSON.toJSONString(map),VideoMessage.class);
            return createVideo().parseVideoMessage(videoMessage);
        }
        if (MsgType.equals(MessageType.shortvideo.toString())) {
            // 短视频消息处理
            VideoMessage videoMessage = JSON.parseObject(JSON.toJSONString(map),VideoMessage.class);
            return createShortVideo().parseShortVideoMessage(videoMessage);
        }
        if (MsgType.equals(MessageType.location.toString())) {
            // 地理信息处理
            LocationMessage locationMessage = JSON.parseObject(JSON.toJSONString(map),LocationMessage.class);
            return createLocation().parseLocationMessage(locationMessage);
        }
        if (MsgType.equals(MessageType.link.toString())) {
            // 链接信息处理
            LinkMessage linkMessage = JSON.parseObject(JSON.toJSONString(map),LinkMessage.class);
            return createLink().parseLinkMessage(linkMessage);
        }
        if (MsgType.equals(MessageType.event.toString())) {
            // 获取事件类型
            String event = map.get(MessageConstants.Event.toString()) + "";
            if (event.equals(EventType.subscribe.toString())) {
                //订阅消息处理
                SubscribeEvent subscribeEvent = JSON.parseObject(JSON.toJSONString(map),SubscribeEvent.class);
                return createSubscribeEvent().parseSubscribeEvent(subscribeEvent);
            }
            if (event.equals(EventType.unsubscribe.toString())) {
                //取消订阅消息处理
                UnSubscribeEvent unSubscribeEvent = JSON.parseObject(JSON.toJSONString(map),UnSubscribeEvent.class);
                return createUnSubscribeEvent().parseUnSubscribeEvent(unSubscribeEvent);
            }
            if (event.equals(EventType.SCAN.toString())) {
                //扫描事件处理
                ScanEvent scanEvent = JSON.parseObject(JSON.toJSONString(map),ScanEvent.class);
                return createScanEvent().parseScanEvent(scanEvent);
            }
            if (event.equals(EventType.LOCATION.toString())) {
                //地理信息事件处理
                LocationEvent locationEvent = JSON.parseObject(JSON.toJSONString(map),LocationEvent.class);
                return createLocationEvent().parseLocationEvent(locationEvent);
            }
            if (event.equals(EventType.CLICK.toString())) {
                //点击菜单事件处理
                ClickMenuEvent clickMenuEvent = JSON.parseObject(JSON.toJSONString(map),ClickMenuEvent.class);
                return createClickMenuEvent().parseClickMenuEvent(clickMenuEvent);
            }
            if (event.equals(EventType.VIEW.toString())) {
                //View菜单事件处理
                ViewMenuEvent viewMenuEvent = JSON.parseObject(JSON.toJSONString(map),ViewMenuEvent.class);
                return createViewMenuEvent().parseViewMenuEvent(viewMenuEvent);
            }
        }
        return null;
    }


    @Override
    public Text createText() {
        return new TextMessageImpl();
    }

    @Override
    public Image createImage() {
        return new ImageMessageImpl();
    }

    @Override
    public Voice createVoice() {
        return new VoiceMessageImpl();
    }

    @Override
    public Video createVideo() {
        return new VideoMessageImpl();
    }

    @Override
    public ShortVideo createShortVideo() {
        return new ShortVideoMessageImpl();
    }

    @Override
    public Location createLocation() {
        return new LocationMessageImpl();
    }

    @Override
    public Link createLink() {
        return new LinkMessageImpl();
    }

    @Override
    public Subscribe createSubscribeEvent() {
        return new SubscribeEventImpl();
    }

    @Override
    public UnSubscribe createUnSubscribeEvent() {
        return new UnSubscribeEventImpl();
    }

    @Override
    public Scan createScanEvent() {
        return new ScanEventImpl();
    }

    @Override
    public com.github.sdcxy.wechat.service.message.event.Location createLocationEvent() {
        return new LocationEventImpl();
    }

    @Override
    public ClickMenu createClickMenuEvent() {
        return new ClickMenuEventImpl();
    }

    @Override
    public ViewMenu createViewMenuEvent() {
        return new ViewMenuEventImpl();
    }
}
