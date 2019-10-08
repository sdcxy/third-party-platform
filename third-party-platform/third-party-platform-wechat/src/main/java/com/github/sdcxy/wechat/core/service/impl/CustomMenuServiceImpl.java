package com.github.sdcxy.wechat.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.sdcxy.wechat.common.util.HttpClientUtils;
import com.github.sdcxy.wechat.core.constants.Constants;
import com.github.sdcxy.wechat.core.constants.UrlConstants;
import com.github.sdcxy.wechat.core.entity.menu.CustomButton;
import com.github.sdcxy.wechat.core.exception.MenuException;
import com.github.sdcxy.wechat.core.service.CustomMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName CustomMenuServiceImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 22:38
 **/
@Service
public class CustomMenuServiceImpl implements CustomMenuService {

    @Override
    public String createCustomMenu(CustomButton customButton, String accessToken) {
        String url = UrlConstants.POST_CREATE_CUSTOM_MENU.replace(Constants.ACCESS_TOKEN,accessToken);
        String result = HttpClientUtils.doPost(url, JSON.toJSONString(customButton),null,null);
        return defaultReturn(result);
    }

    @Override
    public String queryCustomMenu(String accessToken) {
        String url = UrlConstants.GET_QUERY_CUSTOM_MENU.replace(Constants.ACCESS_TOKEN,accessToken);
        String result = HttpClientUtils.doGet(url, null, null);
        return defaultReturn(result);
    }

    @Override
    public String deleteCustomMenu(String accessToken) {
        String url = UrlConstants.POST_DELETE_PERSONALISE_MENU.replace(Constants.ACCESS_TOKEN,accessToken);
        String result =  HttpClientUtils.doPost(url, null, null);
        return defaultReturn(result);
    }

    /**
     * 默认返回数据
     * @param result
     * @return
     */
    private String defaultReturn(String result){
        String errmsg = JSON.parseObject(result).getString(Constants.errMsg);
        if (StringUtils.isEmpty(errmsg)) {
            return result;
        }else {
            String msg = JSON.parseObject(result).getString(Constants.errMsg);
            int code = JSON.parseObject(result).getInteger(Constants.errCode);
            throw new MenuException(code,msg);
        }
    }
}
