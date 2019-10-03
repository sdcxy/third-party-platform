package com.github.sdcxy.wechat.service;

import com.github.sdcxy.wechat.entity.AccessToken;
import com.github.sdcxy.wechat.entity.menu.CustomButton;

public interface CustomMenuService {

    // 创建自定义菜单
    String createCustomMenu(CustomButton customButton, AccessToken accessToken);
    // 查询自定义菜单
    String queryCustomMenu(AccessToken accessToken);
    // 删除自定义菜单
    String deleteCustomMenu(AccessToken accessToken);
}
