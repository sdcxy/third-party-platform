package com.github.sdcxy.wechat.autoconfigure;

import com.github.sdcxy.wechat.core.constants.Constants;
import com.github.sdcxy.wechat.core.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName WeChatAutoConfigure
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/4 23:34
 **/
@Configuration
@EnableConfigurationProperties(value = WeChatProperties.class)
public class WeChatAutoConfigure {

    @Autowired
    private WeChatProperties weChatProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(WeChatService.class)
    @ConditionalOnProperty(prefix = Constants.THIRD_PARTY_PLATFORM + Constants.POINT + Constants.WECHAT,value = Constants.ENABLED,havingValue = "true")
    WeChatProperties weChatProperties(){
        return weChatProperties;
    }
}
