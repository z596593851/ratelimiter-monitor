package com.github.ratelimitermonitor.service;

import com.alibaba.fastjson.JSONObject;
import com.github.ratelimitermonitor.exception.MonitorException;
import com.github.ratelimitermonitor.vo.AppLimitConfigVo;
import com.github.ratelimitermonitor.vo.AppLimitVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class ZkService {

    private Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
    @Autowired
    CuratorFramework client;
    private String zkNodeFullPath="/ratelimiter/node";
    private String zkConfigFullPath="/ratelimiter/config";
    private String split="/";

    /**
     * 获取所有在线的app
     */
    public List<String> getAllApps() throws Exception {
        return client.getChildren().forPath(zkNodeFullPath);
    }

    /**
     * 获取某个app下所有在线的节点ip
     */
    public List<String> getAllNodes(String appName) throws Exception {
        return client.getChildren().forPath(zkNodeFullPath+split+appName);
    }

    /**
     * 获取某个app的限流config
     */
    public List<AppLimitVo> getConfig(String appName) throws Exception {
        String configStr=new String(client.getData().forPath(zkConfigFullPath+split+appName));
        if(!StringUtils.isBlank(configStr) && configStr.startsWith("{")) {
            AppLimitConfigVo config = JSONObject.parseObject(configStr, AppLimitConfigVo.class);
            return config.getLimits();
        }else {
            throw new MonitorException("配置解析出错:"+configStr);
        }
    }

    /**
     * 设置app的限流config
     */
    public void setConfig(AppLimitConfigVo limitConfig) throws Exception {
        List<AppLimitVo> limits = limitConfig.getLimits();
        for(AppLimitVo limit:limits){
            String returnValue=limit.getReturnValue();
            Matcher m = pattern.matcher(returnValue);
            returnValue=m.replaceAll("");
            limit.setReturnValue(returnValue);
        }
        String configStr = JSONObject.toJSONString(limitConfig);
        client.setData().forPath(zkConfigFullPath+split+limitConfig.getAppId(),configStr.getBytes(StandardCharsets.UTF_8));
    }
}
