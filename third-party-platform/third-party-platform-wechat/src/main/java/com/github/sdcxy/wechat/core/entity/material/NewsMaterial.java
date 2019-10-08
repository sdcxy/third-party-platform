package com.github.sdcxy.wechat.core.entity.material;

import lombok.Data;

import java.util.List;

/**
 * @ClassName NewsMaterial
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/6 19:10
 **/
@Data
public class NewsMaterial {

    /**
     * 要修改的图文消息的id
     */
    private String media_id;

    /**
     * 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
     */
    private Integer index;
    /**
     * 图文消息列表
     */
    private List<NewsMaterialItem> articles;
}
