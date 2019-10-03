package com.github.sdcxy.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.util.HttpClientUtils;
import com.github.sdcxy.util.ObjectUtils;
import com.github.sdcxy.wechat.constant.WeChatConstants;
import com.github.sdcxy.wechat.entity.AccessToken;
import com.github.sdcxy.wechat.entity.menu.CustomButton;
import com.github.sdcxy.wechat.service.CustomMenuService;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @ClassName CustomMenuServiceImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 17:01
 **/
public class CustomMenuServiceImpl implements CustomMenuService {


    @Override
    public String createCustomMenu(CustomButton customButton, AccessToken accessToken) {
        String resultStr = null;
        String url = WeChatConstants.POST_CREATE_CUSTOM_MENU
                                    .replace(WeChatConstants.ACCESS_TOKEN,accessToken.getAccessToken());
//        Map<String,Object> parameterMap = ObjectUtils.beanToMap(customButton);
        String result = HttpClientUtils.doPost(url,JSON.toJSONString(customButton),null,null);
        if (StringUtils.isNotEmpty(result)) {
            resultStr = result;
        }
        return resultStr;
    }

    @Override
    public String queryCustomMenu(AccessToken accessToken) {
        String resultStr = null;
        // 查询url
        String url = WeChatConstants.GET_QUERY_CUSTOM_MENU
                                    .replace(WeChatConstants.ACCESS_TOKEN,accessToken.getAccessToken());
        String result = HttpClientUtils.doGet(url,null,null);
        if (StringUtils.isNotEmpty(result)) {
            resultStr = result;
        }
        return resultStr;
    }

    @Override
    public String deleteCustomMenu(AccessToken accessToken) {
        String resultStr = null;
        // 删除url
        String url = WeChatConstants.GET_DELETE_CUSTOM_MENU
                .replace(WeChatConstants.ACCESS_TOKEN,accessToken.getAccessToken());
        String result = HttpClientUtils.doGet(url,null,null);
        if (StringUtils.isNotEmpty(result)) {
            resultStr = result;
        }
        return resultStr;
    }
}
