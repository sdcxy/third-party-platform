package com.github.sdcxy.wechat.service;

import com.github.sdcxy.wechat.entity.kfaccount.KFAccount;
import com.github.sdcxy.wechat.entity.kfaccount.ReceiveKFAccount;

import java.util.List;

public interface KFAccountService {

    // 添加客服账号
    String addKfaccount(KFAccount kfAccount,String accessToken);
    // 更新客服账号
    String updateKfaccount(KFAccount account,String accessToken);
    // 删除客服账号
    String deleteFfaccount(KFAccount account,String accessToken);
    // 设置客服账号头像
    String setFfaccountImage(String media_id,String accessToken);
    // 获取客服账号信息
    List<ReceiveKFAccount> getKfaccount(String accessToken);
}
