package com.github.ratelimitermonitor;

import com.alibaba.fastjson.JSONObject;
import org.apache.curator.framework.CuratorFramework;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ZkTest {

    @Autowired
    CuratorFramework client;

    @Test
    public void selectTest() throws Exception {
        List<String> list = client.getChildren().forPath("/ratelimiter/node/app1");
//        List<String> list = client.getChildren().forPath("/ratelimiter/config");
        System.out.println(JSONObject.toJSONString(list));
    }

    public static void main(String[] args) {
        String s="{\"code\":2,   \n  msg:\"aaa\"}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject.toJSONString());
    }
}
