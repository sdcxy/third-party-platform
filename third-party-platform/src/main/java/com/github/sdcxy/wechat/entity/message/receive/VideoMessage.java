package com.github.sdcxy.wechat.entity.message.receive;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName VideoMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 10:13
 **/
@Data
public class VideoMessage extends BaseMessage {

    /**
     * 视频消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String MediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String ThumbMediaId;
}
