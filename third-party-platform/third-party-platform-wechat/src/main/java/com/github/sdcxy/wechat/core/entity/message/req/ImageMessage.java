package com.github.sdcxy.wechat.core.entity.message.req;

import com.github.sdcxy.wechat.core.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName ImageMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 10:07
 **/
@Data
public class ImageMessage extends BaseMessage {

    /**
     * 图片链接（由系统生成）
     */
    private String PicUrl;

    /**
     * 图片消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String MediaId;
}
