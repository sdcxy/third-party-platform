package com.github.sdcxy.wechat.entity.message.response.message;

import lombok.Data;

/**
 * @ClassName RespMusic
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:45
 **/
@Data
public class RespMusic {

    /**
     * 音乐标题
     */
    private String Title;

    /**
     * 音乐描述
     */
    private String Description;

    /**
     * 音乐链接
     */
    private String MusicURL;

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    private String HQMusicUrl;

    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String ThumbMediaId;
}
