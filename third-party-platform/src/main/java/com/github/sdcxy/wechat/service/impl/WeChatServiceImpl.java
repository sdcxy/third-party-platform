package com.github.sdcxy.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.sdcxy.util.HttpClientUtils;
import com.github.sdcxy.wechat.config.SignatureConfig;
import com.github.sdcxy.wechat.constant.WeChatConstants;
import com.github.sdcxy.wechat.entity.AccessToken;
import com.github.sdcxy.wechat.service.WeChatService;
import com.github.sdcxy.wechat.util.MessageUtils;
import com.github.sdcxy.wechat.util.SignatureUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName WeChatServiceImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 11:19
 **/
public class WeChatServiceImpl implements WeChatService {

    @Override
    public String weChatIn(SignatureConfig signatureConfig, String token) {
        boolean checkSignature = SignatureUtils.checkSignature(signatureConfig,token);
        if (checkSignature) {
            return signatureConfig.getEchostr();
        } else {
            return  null;
        }
    }

    @Override
    public String weChatCallBack(HttpServletRequest request,SignatureConfig signatureConfig, String token) {
        return null;
    }

    @Override
    public String weChatCallBack(HttpServletRequest request,String token) {
        String resultStr = null;
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        SignatureConfig signatureConfig = new SignatureConfig(signature,timestamp,nonce,"");
        if (SignatureUtils.checkSignature(signatureConfig,token)) {
            // 将xml 转换成map
            Map<String,Object> map = MessageUtils.xmlToMap(request);
            // 进行消息处理
            MessageServiceImpl messageService = new MessageServiceImpl();
            resultStr = messageService.parseMessage(map);
            //
        }
        return resultStr;
    }

    @Override
    public AccessToken getWeChatAccessToken(String appId, String appSecret) {
        String url = WeChatConstants.GET_ACCESS_TOKEN_URL
                                    .replace(WeChatConstants.APPID,appId)
                                    .replace(WeChatConstants.APPSECRET,appSecret);
        AccessToken accessToken = null;
        String result = HttpClientUtils.doGet(url,null,null);
        if (StringUtils.isNotEmpty(result)) {
            accessToken = new AccessToken();
            JSONObject jsonToken = JSON.parseObject(result);
            accessToken.setAccessToken(jsonToken.getString("access_token"));
            accessToken.setExpiresIn(jsonToken.getLong("expires_in"));
            // 获取创建时间
            long now = System.currentTimeMillis();
            accessToken.setCreateTime(now);
            accessToken.setExpriedTime( now + accessToken.getExpiresIn());
        }
        return accessToken;
    }
}
