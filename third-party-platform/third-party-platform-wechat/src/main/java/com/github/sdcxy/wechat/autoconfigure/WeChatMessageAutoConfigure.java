package com.github.sdcxy.wechat.autoconfigure;

import com.github.sdcxy.wechat.core.service.MessageService;
import com.github.sdcxy.wechat.core.service.message.*;
import com.github.sdcxy.wechat.core.service.message.Location;
import com.github.sdcxy.wechat.core.service.message.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @ClassName WeChatMessageAutoConfig
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 1:49
 **/
@Configuration
@ConditionalOnClass(value = MessageService.class)
@EnableConfigurationProperties
public class WeChatMessageAutoConfigure {

    @Resource
    private Text text;

    @Resource
    private Image image;

    @Resource
    private Voice voice;

    @Resource
    private Video video;

    @Resource
    private Location location;

    @Resource
    private Music music;

    @Resource
    private News news;

    @Resource
    private Link link;

    @Resource
    private Subscribe subscribe;

    @Resource
    private UnSubscribe unSubscribe;

    @Resource
    private Scan scan;

    @Resource
    private ClickMenu clickMenu;

    @Resource
    private ViewMenu viewMenu;

    @Resource
    private com.github.sdcxy.wechat.core.service.message.event.Location locationEvent;

    @Bean
    @ConditionalOnMissingBean
    GlobalConfig globalConfig() {
        return new GlobalConfig().setText(text)
                                .setImag(image)
                                .setVoice(voice)
                                .setVideo(video)
                                .setLocation(location)
                                .setLink(link)
                                .setMusic(music)
                                .setNews(news)
                                .setSubscribe(subscribe)
                                .setUnSubscribe(unSubscribe)
                                .setScan(scan)
                                .setLocationEvent(locationEvent)
                                .setClickMenu(clickMenu)
                                .setViewMenu(viewMenu);
    }

}
