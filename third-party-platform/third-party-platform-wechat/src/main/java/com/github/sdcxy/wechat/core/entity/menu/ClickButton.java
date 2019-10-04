package com.github.sdcxy.wechat.core.entity.menu;

import lombok.Data;

/**
 * @ClassName ClickButton
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 16:14
 **/
@Data
public class ClickButton extends BaseButton {

    private String key;
    private String type = "click";

}
