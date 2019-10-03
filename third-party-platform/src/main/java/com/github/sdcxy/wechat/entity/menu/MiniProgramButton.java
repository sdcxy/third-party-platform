package com.github.sdcxy.wechat.entity.menu;

import lombok.Data;

/**
 * @ClassName MiniProgramButton
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 16:14
 **/
@Data
public class MiniProgramButton extends BaseButton {

    private String appid;

    private String pagepath;

    private String url;

    private String type = "miniprogram";
}
