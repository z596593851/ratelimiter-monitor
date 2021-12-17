package com.github.ratelimitermonitor.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZkConfig {

    @Bean
    public CuratorFramework getCurator(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client= CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").sessionTimeoutMs(10000).retryPolicy(retryPolicy).build();
        client.start();
        return client;
    }
}
