package com.github.sdcxy.wechat.entity.message.response.message;

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
