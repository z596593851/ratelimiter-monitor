package com.github.ratelimitermonitor.exception;

public enum ErrorEnum {

    /**
     * 系统错误
     */
    SYS_ERROR("系统错误"),
    ;

    private final String errorMsg;

    ErrorEnum(String errorMsg){
        this.errorMsg=errorMsg;
    }

    public String getErrorMsg(){
        return this.errorMsg;
    }
}
