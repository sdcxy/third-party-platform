package com.github.sdcxy.weixin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WeiXinConfig
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/4 0:12
 **/
@Configuration
@ConfigurationProperties(prefix = "weixin")
public class WeiXinConfig extends com.github.sdcxy.wechat.config.WeChatConfig {

}
