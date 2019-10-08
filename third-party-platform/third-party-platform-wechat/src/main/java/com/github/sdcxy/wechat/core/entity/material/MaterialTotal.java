package com.github.sdcxy.wechat.core.entity.material;

import lombok.Data;

/**
 * @ClassName MaterialTotal
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/7 3:44
 **/
@Data
public class MaterialTotal {

    /**
     * 语音总数量
     */
    private Integer voice_count;

    /**
     * 视频总数量
     */
    private Integer video_count;

    /**
     * 图片总数量
     */
    private Integer image_count;

    /**
     * 图文总数量
     */
    private Integer news_count;
}
