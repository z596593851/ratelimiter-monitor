package com.github.ratelimitermonitor.vo;

import java.util.List;

public class AppLimitConfigVo {
    private String appId;
    private String returnValue;
    private List<AppLimitVo> limits;

    public AppLimitConfigVo() {}

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public List<AppLimitVo> getLimits() {
        return limits;
    }

    public void setLimits(List<AppLimitVo> limits) {
        this.limits = limits;
    }
}
