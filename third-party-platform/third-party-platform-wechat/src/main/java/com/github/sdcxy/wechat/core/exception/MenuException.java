package com.github.sdcxy.wechat.core.exception;

import lombok.Data;

/**
 * @ClassName MenuException
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/7 12:42
 **/
@Data
public class MenuException extends GlobalException {

    public MenuException(int code, String msg) {
        super(code, msg);
    }
}
