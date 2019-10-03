package com.github.sdcxy.wechat.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName AccessToken
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 9:54
 **/
@Data
public class AccessToken {

    /**
     * 获取到的凭证
     */
    private String accessToken;

    /**
     * 凭证有效时间，单位：秒
     */
    private long expiresIn;

    /**
     * token 创建时间
     */
    private long createTime;

    /**
     * token 过期时间
     */
    private long expriedTime;
}
