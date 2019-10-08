package com.github.sdcxy.wechat.core.entity.material.list;

import lombok.Data;

/**
 * @ClassName OtherTypeMaterialItem
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/7 12:30
 **/
@Data
public class OtherTypeMaterialItem extends BaseMaterialItem {

    /**
     *  文件名称
     */
    private String name;

    /**
     * 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
     */
    private String url;
}
