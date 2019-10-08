package com.github.sdcxy.wechat.core.entity.message.event;

import com.github.sdcxy.wechat.core.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName ScanEvent
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 13:33
 **/
@Data
public class ScanEvent extends BaseMessage {

    /**
     * 事件类型，SCAN
     */
    private String Event = "SCAN";
    /**
     * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    private String EventKey;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String Ticket;
}
