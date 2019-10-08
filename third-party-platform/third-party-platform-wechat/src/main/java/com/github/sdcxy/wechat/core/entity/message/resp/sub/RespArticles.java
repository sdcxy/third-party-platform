package com.github.sdcxy.wechat.core.entity.message.resp.sub;

import lombok.Data;

import java.util.List;


/**
 * @ClassName RespArticles
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:47
 **/
@Data
public class RespArticles {
    private List<RespArticlesItem> item;
}
