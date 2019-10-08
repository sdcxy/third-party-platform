package com.github.sdcxy.wechat.core.entity.material.list;

import lombok.Data;

/**
 * @ClassName BaseMaterialItem
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/7 12:25
 **/
@Data
public class BaseMaterialItem {

    /**
     * 多媒体文件 media_id
     */
    private String media_id;

    /**
     * 这篇图文消息素材的最后更新时间
     */
    private String update_time;
}
