package com.github.sdcxy.wechat.core.service;

import com.github.sdcxy.wechat.core.entity.menu.CustomButton;

public interface CustomMenuService {
    // 创建自定义菜单
    String createCustomMenu(CustomButton customButton, String accessToken);
    // 查询自定义菜单
    String queryCustomMenu(String accessToken);
    // 删除自定义菜单
    String deleteCustomMenu(String  accessToken);
}
