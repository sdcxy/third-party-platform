package com.github.sdcxy.wechat.core.entity.material;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName VideoMaterial
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/6 23:21
 **/
@Accessors(chain = true)
@Data
public class VideoMaterial {
    /**
     * 标题
     */
    private String title;

    /**
     * 说明
     */
    private String description;

    /**
     * 下载地址
     */
    private String down_url;
}
