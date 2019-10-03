package com.github.sdcxy.weixin.controller;

import com.github.sdcxy.wechat.config.SignatureConfig;
import com.github.sdcxy.weixin.config.WeiXinConfig;
import com.github.sdcxy.wechat.service.impl.WeChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName WeiXinController
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/4 0:16
 **/
@Controller
public class WeiXinController {

    @Autowired
    private WeiXinConfig weiXinConfig;

    @GetMapping(value = "/wechat/in")
    @ResponseBody
    public String WeChatIn(String signature,String timestamp,String nonce,String echostr ){
        WeChatServiceImpl weChatService = new WeChatServiceImpl();
        SignatureConfig signatureConfig = new SignatureConfig(signature,timestamp,nonce,echostr);
        return weChatService.weChatIn(signatureConfig, weiXinConfig.getToken());
    }


    @PostMapping(value = "/wechat/in")
    @ResponseBody
    public String WeChatOut(HttpServletRequest request) {
        WeChatServiceImpl weChatService = new WeChatServiceImpl();
        return weChatService.weChatCallBack(request, weiXinConfig.getToken());
    }



}
