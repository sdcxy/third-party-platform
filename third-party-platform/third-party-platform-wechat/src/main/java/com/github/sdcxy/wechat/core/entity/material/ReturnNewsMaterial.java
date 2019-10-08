package com.github.sdcxy.wechat.core.entity.material;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ReturnNewsMaterial
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/6 23:17
 **/
@Data
public class ReturnNewsMaterial {
    /**
     * 返回的图文素材列表
     */
   private List<NewsMaterialItem> news_item;
}
