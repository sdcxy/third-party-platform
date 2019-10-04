package com.github.sdcxy.wechat.autoconfigure;

import com.github.sdcxy.wechat.core.constants.Constants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName WeChatProperties
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/4 23:33
 **/
@ConfigurationProperties(prefix = Constants.THIRD_PARTY_PLATFORM + Constants.POINT + Constants.WECHAT)
@Data
public class WeChatProperties {

    /**
     * 启动使能
     */
    private boolean enabled = true;

    /**
     * 开发者ID(AppID)
     */
    private String appId ="";

    /**
     * 开发者密码(AppSecret)
     */
    private String appSecret = "";

    /**
     * 令牌(Token)
     */
    private String token = "";

    /**
     * 公众微信号
     */
    private String wechat = "";
}
