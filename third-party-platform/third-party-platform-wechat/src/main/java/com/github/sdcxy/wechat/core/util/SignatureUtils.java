package com.github.sdcxy.wechat.core.util;

import com.github.sdcxy.wechat.common.util.EncryptUtils;
import com.github.sdcxy.wechat.core.entity.SignatureConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @ClassName SignatureUtils
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 10:00
 **/
public class SignatureUtils {

    /**
     *  校验微信公众号签名
     * @param signatureConfig
     * @param token
     * @return
     */
    public static boolean checkSignature(SignatureConfig signatureConfig, String token) {
        boolean resultFlag = false;
        if (signatureConfig != null) {
            // 用数据保存起来
            String arr[] = new String[]{token,signatureConfig.getTimestamp(),signatureConfig.getNonce()};

            // 进行字典排序
            Arrays.sort(arr);

            // 生成字符串
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            // sha1加密
            String encryptSignature = EncryptUtils.sha1(sb.toString());

            // 判断签名
            if (StringUtils.equals(encryptSignature,signatureConfig.getSignature())) {
                resultFlag =  true;
            }
        }
        return resultFlag;
    }
}
