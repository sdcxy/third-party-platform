package com.github.sdcxy.wechat.service.message;
import com.github.sdcxy.wechat.service.message.event.*;

public interface MessageFactory {

    Text createText();
    Image createImage();
    Voice createVoice();
    Video createVideo();
    ShortVideo createShortVideo();
    Location createLocation();
    Link createLink();

    // 事件
    Subscribe createSubscribeEvent();
    UnSubscribe createUnSubscribeEvent();
    Scan createScanEvent();
    com.github.sdcxy.wechat.service.message.event.Location createLocationEvent();
    ClickMenu createClickMenuEvent();
    ViewMenu createViewMenuEvent();
}
