package com.github.ratelimitermonitor.model;

public enum ResCode {
    /**
     * 不可捕获的异常
     */
    UNCATCHEABLE_EXC(500),
    /**
     * 可捕获的异常
     */
    CATCHEABLE_EXC(600),
    ;
    private final int code;

    ResCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
