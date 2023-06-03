package com.qhx.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProExceptionAdvice {
    @ExceptionHandler({Exception.class})
    public Rest exception(Exception e){
        return new Rest("出异常了",Code.EXCEPTION_ERR);
    }
}
