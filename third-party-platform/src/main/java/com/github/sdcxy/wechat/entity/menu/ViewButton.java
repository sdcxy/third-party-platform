package com.github.sdcxy.wechat.entity.menu;

import lombok.Data;

/**
 * @ClassName ViewButton
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 16:13
 **/
@Data
public class ViewButton extends BaseButton {

    private String url;

    private String type = "view";
}
