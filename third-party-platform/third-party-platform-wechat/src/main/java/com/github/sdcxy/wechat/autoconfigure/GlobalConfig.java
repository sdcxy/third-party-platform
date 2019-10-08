package com.github.sdcxy.wechat.autoconfigure;

import com.github.sdcxy.wechat.core.service.message.*;
import com.github.sdcxy.wechat.core.service.message.Location;
import com.github.sdcxy.wechat.core.service.message.event.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName GlobalConfig
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/5 1:23
 **/
@Data
@Accessors(chain = true)
public class GlobalConfig {

    private Text text;

    private Image imag;

    private Voice voice;

    private Video video;

    private Location location;

    private Music music;

    private News news;

    private Link link;

    private Subscribe subscribe;

    private UnSubscribe unSubscribe;

    private Scan scan;

    private ClickMenu clickMenu;

    private ViewMenu viewMenu;

    private com.github.sdcxy.wechat.core.service.message.event.Location locationEvent;

}
