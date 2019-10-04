package com.github.sdcxy.wechat.core.entity.menu;

import lombok.Data;

/**
 * @ClassName ComplexButton
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 16:53
 **/
@Data
public class ComplexButton extends BaseButton {
    private BaseButton[] sub_button;
}
