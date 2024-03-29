package com.github.sdcxy.wechat.core.entity.message.resp;

import com.github.sdcxy.wechat.core.entity.message.BaseMessage;
import com.github.sdcxy.wechat.core.entity.message.resp.sub.RespArticles;
import lombok.Data;

/**
 * @ClassName RespNewsMessage
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/1 0:16
 **/
@Data
public class RespNewsMessage extends BaseMessage {

    /**
     * 图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
     */
    private String ArticleCount;

    /**
     * 图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
     */
    private RespArticles Articles;


}
