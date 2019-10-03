package com.github.sdcxy.wechat.entity.kfaccount;

import lombok.Data;

/**
 * @ClassName ReceiveKFAccount
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/3 13:57
 **/
@Data
public class ReceiveKFAccount {

    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    private String kf_account;

    /**
     *客服昵称
     */
    private String kf_nick;

    /**
     * 客服工号
     */
    private String kf_id;

    /**
     * 客户账号头像
     */
    private String kf_headimgurl;

}
