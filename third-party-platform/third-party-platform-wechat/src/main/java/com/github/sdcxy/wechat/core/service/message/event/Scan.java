package com.github.sdcxy.wechat.core.service.message.event;


import com.github.sdcxy.wechat.core.entity.message.event.ScanEvent;

public interface Scan {
    String parseScanEvent(ScanEvent scanEvent);
}
