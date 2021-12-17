package com.github.ratelimitermonitor.aop;

import java.lang.annotation.*;

/**
 * @author xiaoming
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     */
    String description() default "";

}

