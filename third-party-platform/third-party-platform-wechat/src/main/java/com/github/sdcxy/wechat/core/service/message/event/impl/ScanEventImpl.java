package com.github.sdcxy.wechat.core.service.message.event.impl;


import com.github.sdcxy.wechat.core.entity.message.event.ScanEvent;
import com.github.sdcxy.wechat.core.service.message.event.Scan;
import com.github.sdcxy.wechat.core.util.MessageUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName ScanEventImpl
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/2 14:35
 **/
@Service
public class ScanEventImpl implements Scan {
    @Override
    public String parseScanEvent(ScanEvent scanEvent) {
        return MessageUtils.parseDefaultMessage(scanEvent);
    }
}
