package com.github.sdcxy.wechat.entity.message.response.message;

import lombok.Data;

/**
 * @ClassName RespImage
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:38
 **/
@Data
public class RespImage {
    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String MediaId;
}
