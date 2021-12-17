package com.github.ratelimitermonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
public class RatelimiterMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatelimiterMonitorApplication.class, args);
    }

}
