package com.github.ratelimitermonitor.aop;

import com.github.ratelimitermonitor.exception.ErrorEnum;
import com.github.ratelimitermonitor.exception.MonitorException;
import com.github.ratelimitermonitor.model.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = MonitorException.class)
    public ResResult<Void> bizExceptionHandler(MonitorException e) {
        log.error(e.getMessage(), e);
        //要返回给前台的错误提示
        return ResResult.fail(e.getErrorMsg());
    }

    /**
     *处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    public ResResult<Void> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        //要返回给前台的错误提示
        return ResResult.fail(ErrorEnum.SYS_ERROR.getErrorMsg());

    }

}
