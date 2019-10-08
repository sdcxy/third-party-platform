package com.github.sdcxy.wechat.core.entity.material.list;

import lombok.Data;

import java.util.List;

/**
 * @ClassName NewsMaterialList
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/7 12:15
 **/
@Data
public class NewsMaterialList extends BaseMaterial {
    /**
     *  图文消息的永久素材列表
     */
    private List<NewsMaterialSubItem> item;
}
