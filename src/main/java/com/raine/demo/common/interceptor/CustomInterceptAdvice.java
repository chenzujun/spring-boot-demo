package com.raine.demo.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;

/**
 * @author chenjun
 * @date 2019/3/29
 * @since V1.0
 */
@ControllerAdvice
public class CustomInterceptAdvice {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截异常
     *
     * @param e
     * @param m
     * @return
     */
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handle(Exception e, HandlerMethod m) {
        log.info("CustomInterceptAdvice handle exception {}, method: {}", e.getMessage(), m.getMethod().getName());
        return e.getMessage();
    }
}
