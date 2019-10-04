package com.github.sdcxy.wechat.core.service;

import com.github.sdcxy.wechat.core.entity.AccessToken;
import com.github.sdcxy.wechat.core.entity.SignatureConfig;

import javax.servlet.http.HttpServletRequest;

public interface WeChatService {

    // 微信公众号接入
    String weChatIn(SignatureConfig signatureConfig);

    // 微信公众号回调
    String weChatCallBack(HttpServletRequest request);

    // 获取微信公众号access_token
    AccessToken getWeChatAccessToken(String appId, String appSecret);
}
