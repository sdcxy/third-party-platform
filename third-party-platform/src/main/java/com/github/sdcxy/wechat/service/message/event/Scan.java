package com.github.sdcxy.wechat.service.message.event;

import com.github.sdcxy.wechat.entity.message.event.ScanEvent;

public interface Scan {
    String parseScanEvent(ScanEvent scanEvent);
}
