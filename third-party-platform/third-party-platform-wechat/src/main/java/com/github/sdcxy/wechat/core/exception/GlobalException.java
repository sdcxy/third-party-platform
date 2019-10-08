package com.github.sdcxy.wechat.core.exception;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private String msg;
    private Integer code;

    public GlobalException(int code,String msg){
        super(msg);
        this.code = code;
    }
}
