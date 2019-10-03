package com.github.sdcxy.wechat.config;

import lombok.Data;

/**
 * @ClassName WeChatConfig
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 9:44
 **/
@Data
public class WeChatConfig {

    /**
     * 开发者ID(AppID)
     */
    private String appId;

    /**
     * 开发者密码(AppSecret)
     */
    private String appSecret;

    /**
     * 令牌(Token)
     */
    private String token;

    /**
     * 公众微信号
     */
    private String wechat;
}
