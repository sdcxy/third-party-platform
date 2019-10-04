package com.github.sdcxy.wechat.core.entity;

import lombok.Data;

/**
 * @ClassName SignatureConfig
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 9:48
 **/
@Data
public class SignatureConfig {

    /**
     * 微信加密签名
     */
    private String signature;

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 随机数
     */
    private String nonce;

    /**
     * 随机字符串
     */
    private String echostr;

    public SignatureConfig(){}

    public SignatureConfig(String signature, String timestamp, String nonce, String echostr){
        this.signature = signature;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.echostr = echostr;
    }

    // 对象常量
    public static String SIGNATURE = "signature";
    public static String TIMESTAMP = "timestamp";
    public static String NONCE = "nonce";
    public static String ECHOSTR = "echostr";
}
