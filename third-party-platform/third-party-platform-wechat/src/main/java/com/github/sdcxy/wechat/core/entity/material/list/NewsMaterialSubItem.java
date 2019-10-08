package com.github.sdcxy.wechat.core.entity.material.list;


import com.github.sdcxy.wechat.core.entity.material.ReturnNewsMaterial;
import lombok.Data;

/**
 * @ClassName NewsMaterialSubItem
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/7 12:24
 **/
@Data
public class NewsMaterialSubItem extends BaseMaterialItem {

    /**
     * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     */
    private ReturnNewsMaterial content;
}
