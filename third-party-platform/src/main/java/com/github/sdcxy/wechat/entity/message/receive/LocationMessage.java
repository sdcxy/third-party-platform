package com.github.sdcxy.wechat.entity.message.receive;

import com.github.sdcxy.wechat.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName LocationMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/30 10:15
 **/
@Data
public class LocationMessage extends BaseMessage {

    /**
     * 地理位置维度
     */
    private double Location_X;

    /**
     * 地理位置经度
     */
    private double Location_Y;

    /**
     * 地图缩放大小
     */
    private int Scale;

    /**
     * 地理位置信息
     */
    private String Label;


}
