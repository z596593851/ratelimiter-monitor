package com.github.ratelimitermonitor.exception;

public class MonitorException extends RuntimeException{

    /**
     * 错误提示
     */
    private String errorMsg;

    public MonitorException(Exception exception){
        this(exception.getMessage());
    }

    public MonitorException(ErrorEnum errorEnum){
        this(errorEnum.getErrorMsg());
    }

    public MonitorException(String errorMsg){
        super(errorMsg);
        this.errorMsg=errorMsg;
    }

    public MonitorException(){
        super();
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
