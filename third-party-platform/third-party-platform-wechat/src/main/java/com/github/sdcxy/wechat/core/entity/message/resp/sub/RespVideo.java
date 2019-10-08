package com.github.sdcxy.wechat.core.entity.message.resp.sub;

import lombok.Data;

/**
 * @ClassName RespVideo
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:45
 **/
@Data
public class RespVideo {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String  MediaId;

    /**
     * 视频消息的标题
     */
    private String Title;

    /**
     * 视频消息的描述
     */
    private String Description;
}
