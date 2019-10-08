package com.github.sdcxy.wechat.core.entity.material;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName Material
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/6 1:43
 **/
@Data
@Accessors(chain = true)
public class Material {
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    private String type;

    /**
     * 媒体文件上传后，获取标识
     */
    private String media_id;

    /**
     * 媒体文件上传时间戳
     */
    private String created_at;
    /**
     * 新增永久图片素材返回的url
     */
    String url;
}
