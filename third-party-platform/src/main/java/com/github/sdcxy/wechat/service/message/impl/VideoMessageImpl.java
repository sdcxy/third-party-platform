package com.github.sdcxy.wechat.service.message.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.ParseXmlUtils;
import com.github.sdcxy.wechat.entity.message.receive.VideoMessage;
import com.github.sdcxy.wechat.entity.message.response.RespTextMessage;
import com.github.sdcxy.wechat.entity.message.response.RespVideoMessage;
import com.github.sdcxy.wechat.entity.message.response.RespVoiceMessage;
import com.github.sdcxy.wechat.entity.message.response.message.RespVideo;
import com.github.sdcxy.wechat.service.message.Video;
import com.github.sdcxy.wechat.util.MessageUtils;

/**
 * @ClassName VideoMessageImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 17:57
 **/
public class VideoMessageImpl implements Video {
    @Override
    public String parseVideoMessage(VideoMessage videoMessage) {
        // 获取互换后的发送者和接收者
        String ToUserName = videoMessage.getFromUserName();
        String FromUserName = videoMessage.getToUserName();
        // 转换成响应信息类
//        RespVideoMessage respVideoMessage = JSON.parseObject(JSON.toJSONString(videoMessage), RespVideoMessage.class);

        // 发送者与接收者互换
//        respVideoMessage.setFromUserName(FromUserName);
//        respVideoMessage.setToUserName(ToUserName);

        //设置返回的视频信息
//        RespVideo respVideo = new RespVideo();
        // 先获取临时素材的视频MediaId 进行数据返回
//        respVideo.setMediaId(videoMessage.getMediaId());
//        respVideo.setTitle("视频标题");
//        respVideo.setDescription("视频消息响应");
//        respVideoMessage.setVideo(respVideo);

       return MessageUtils.replyTextMessage(FromUserName,ToUserName,videoMessage);

    }
}
