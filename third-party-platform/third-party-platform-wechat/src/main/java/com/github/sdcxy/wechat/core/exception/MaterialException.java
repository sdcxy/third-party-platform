package com.github.sdcxy.wechat.core.exception;

import lombok.Data;

/**
 * @ClassName MaterialException
 * @Description TODO
 * @Author lxx
 * @Date 2019/10/7 12:41
 **/
@Data
public class MaterialException extends GlobalException{

    public MaterialException(int code, String msg) {
        super(code, msg);
    }
}
