package com.github.sdcxy.wechat.core.entity.material.list;

import lombok.Data;

import java.util.List;

/**
 * @ClassName OtherTypeMaterialList
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/7 12:31
 **/
@Data
public class OtherTypeMaterialList extends BaseMaterial{
    /**
     *  其他类型的永久素材列表
     */
    private List<OtherTypeMaterialItem> item;
}
