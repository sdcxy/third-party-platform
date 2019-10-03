package com.github.sdcxy.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.HttpClientUtils;
import com.github.sdcxy.util.ObjectUtils;
import com.github.sdcxy.wechat.constant.WeChatConstants;
import com.github.sdcxy.wechat.entity.AccessToken;
import com.github.sdcxy.wechat.entity.kfaccount.KFAccount;
import com.github.sdcxy.wechat.entity.kfaccount.ReceiveKFAccount;
import com.github.sdcxy.wechat.service.KFAccountService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName KFAccountServiceImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/3 14:03
 **/
public class KFAccountServiceImpl implements KFAccountService {

    @Override
    public String addKfaccount(KFAccount kfAccount, String accessToken) {
        String url = WeChatConstants.POST_ADD_KFACCOUNT
                .replace(WeChatConstants.ACCESS_TOKEN, accessToken);
        // 发送http请求
        return HttpClientUtils.doPost(url, JSON.toJSONString(kfAccount), null, null);
    }

    @Override
    public String updateKfaccount(KFAccount kfAccount, String accessToken) {
        String url = WeChatConstants.POST_UPDATE_KFACCOUNT
                .replace(WeChatConstants.ACCESS_TOKEN, accessToken);
        // 发送http请求
        return HttpClientUtils.doPost(url, JSON.toJSONString(kfAccount), null, null);
    }

    @Override
    public String deleteFfaccount(KFAccount kfAccount, String accessToken) {
        String url = WeChatConstants.POST_DELETE_KFACCOUNT
                .replace(WeChatConstants.ACCESS_TOKEN, accessToken);
        // 发送http请求
        return HttpClientUtils.doPost(url, JSON.toJSONString(kfAccount), null, null);
    }

    @Override
    public String setFfaccountImage(String media_id, String accessToken) {
        return null;
    }

    @Override
    public List<ReceiveKFAccount> getKfaccount(String accessToken) {
        String url = WeChatConstants.GET_GET_KFACCOUNT
                .replace(WeChatConstants.ACCESS_TOKEN, accessToken);
        // 发送http请求
        String resultStr = HttpClientUtils.doGet(url,null,null);
        return JSON.parseArray(resultStr, ReceiveKFAccount.class);
    }
}
