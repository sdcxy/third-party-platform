package com.github.sdcxy.wechat.core.entity.message.resp.sub;

import lombok.Data;

/**
 * @ClassName RespVoice
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:44
 **/
@Data
public class RespVoice {
    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String MediaId;
}
