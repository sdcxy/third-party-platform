package com.github.sdcxy.wechat.service;

import com.github.sdcxy.wechat.config.SignatureConfig;
import com.github.sdcxy.wechat.entity.AccessToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WeChatService {

    // 微信公众号接入
    String weChatIn(SignatureConfig signatureConfig,String token);

    // 微信公众号回调
    String weChatCallBack(HttpServletRequest request,SignatureConfig signatureConfig, String token);

    // 微信公众号回调
    String weChatCallBack(HttpServletRequest request,String token);


    // 获取微信公众号access_token
    AccessToken getWeChatAccessToken(String appId,String appSecret);
}
