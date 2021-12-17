package com.github.ratelimitermonitor.controller;

import com.github.ratelimitermonitor.aop.WebLog;
import com.github.ratelimitermonitor.model.ResResult;
import com.github.ratelimitermonitor.service.ZkService;
import com.github.ratelimitermonitor.vo.AppLimitConfigVo;
import com.github.ratelimitermonitor.vo.AppLimitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limit")
public class LimitConfigController {

    @Autowired
    ZkService zkService;


    @GetMapping("/getAllApps")
    @WebLog
    public ResResult<List<String>> getAllApps() throws Exception {
        return ResResult.success(zkService.getAllApps());
    }


    @GetMapping("/getConfig")
    @WebLog
    public ResResult<List<AppLimitVo>> getConfig(@RequestParam("appName") String appName) throws Exception {
        return ResResult.success(zkService.getConfig(appName));
    }


    @PostMapping("/setConfig")
    @WebLog
    public ResResult<List<String>> setConfig(@RequestBody AppLimitConfigVo config) throws Exception {
        zkService.setConfig(config);
        return ResResult.success();
    }


}
