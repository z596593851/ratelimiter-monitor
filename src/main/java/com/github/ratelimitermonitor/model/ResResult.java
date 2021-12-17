package com.github.ratelimitermonitor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResResult<T> {
    /**
     * 0-成功 1-失败
     */
    private int code;
    private T data;
    private String msg;

    public static<C> ResResult<C> success(C data){
        return new ResResult<C>(0,data,"success");
    }

    public static<C> ResResult<C> success(){
        return new ResResult<>(0,null,"success");
    }

    public static<C> ResResult<C> fail(String msg){
        return new ResResult<>(1,null,msg);
    }

    public static<C> ResResult<C> fail(int code, String msg){
        return new ResResult<>(code,null,msg);
    }
}
