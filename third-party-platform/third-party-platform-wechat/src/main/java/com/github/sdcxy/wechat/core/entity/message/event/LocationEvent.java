package com.github.sdcxy.wechat.core.entity.message.event;


import com.github.sdcxy.wechat.core.entity.message.BaseMessage;
import lombok.Data;

/**
 * @ClassName LocationEvent
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 13:50
 **/
@Data
public class LocationEvent extends BaseMessage {


    /**
     * 事件类型，LOCATION
     */
    private String Event = "LOCATION";
    /**
     * 地理位置纬度
     */
    private String Latitude;

    /**
     * 地理位置经度
     */
    private String Longitude;

    /**
     * 地理位置精度
     */
    private String Precision;
}
