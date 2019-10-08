package com.github.sdcxy.wechat.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.sdcxy.wechat.autoconfigure.WeChatProperties;
import com.github.sdcxy.wechat.common.util.HttpClientUtils;
import com.github.sdcxy.wechat.autoconfigure.GlobalConfig;
import com.github.sdcxy.wechat.core.constants.Constants;
import com.github.sdcxy.wechat.core.constants.UrlConstants;
import com.github.sdcxy.wechat.core.entity.AccessToken;
import com.github.sdcxy.wechat.core.entity.SignatureConfig;
import com.github.sdcxy.wechat.core.exception.GlobalException;
import com.github.sdcxy.wechat.core.service.MessageService;
import com.github.sdcxy.wechat.core.service.WeChatService;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import com.github.sdcxy.wechat.core.util.SignatureUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName WeChatServiceImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/4 23:50
 **/
@Service
public class WeChatServiceImpl implements WeChatService {

    @Autowired
    private WeChatProperties weChatProperties;

    @Autowired
    private MessageService messageService;

    @Override
    public String weChatIn(SignatureConfig signatureConfig) {
        String resultStr = null;
        boolean checkSignature = SignatureUtils.checkSignature(signatureConfig,weChatProperties.getToken());
        if (checkSignature) {
            resultStr =  signatureConfig.getEchostr();
        }else {
            // 接入失败 抛出异常并捕获
            throw new GlobalException(-1,"微信接入失败");
        }
        return resultStr;
    }

    @Override
    public String weChatCallBack(HttpServletRequest request) {
        String resultStr = null;
        String signature = request.getParameter(SignatureConfig.SIGNATURE);
        String timestamp = request.getParameter(SignatureConfig.TIMESTAMP);
        String nonce = request.getParameter(SignatureConfig.NONCE);
        // 封装SignatureConfig
        SignatureConfig signatureConfig = new SignatureConfig(signature,timestamp,nonce,"");

        if (SignatureUtils.checkSignature(signatureConfig,weChatProperties.getToken())) {
            // 将xml 转换成map
            Map<String,Object> map = MessageUtils.xmlToMap(request);
            resultStr = messageService.parseMessage(map);
        } else {
            // 回调失败 抛出异常并捕获
            throw new GlobalException(-1,"微信回调信息失败");
        }

        return resultStr;
    }

    @Override
    public AccessToken getWeChatAccessToken(String appId, String appSecret) {
        String url = UrlConstants.GET_ACCESS_TOKEN_URL
                .replace(Constants.APPID,appId)
                .replace(Constants.APPSECRET,appSecret);
        AccessToken accessToken = null;
        String result = HttpClientUtils.doGet(url,null,null);
        if (StringUtils.isNotEmpty(result)) {
            accessToken = new AccessToken();
            JSONObject jsonToken = JSON.parseObject(result);
            accessToken.setAccessToken(jsonToken.getString(AccessToken.ACCESS_TOKEN));
            accessToken.setExpiresIn(jsonToken.getLong(AccessToken.EXPIRES_IN));
            // 获取创建时间
            long now = System.currentTimeMillis();
            accessToken.setCreateTime(now);
            accessToken.setExpriedTime( now + accessToken.getExpiresIn());
        }else{
            String msg = JSON.parseObject(result).getString(Constants.errMsg);
            int code = JSON.parseObject(result).getInteger(Constants.errCode);
            throw new GlobalException(code,msg);
        }
        return accessToken;
    }
}
