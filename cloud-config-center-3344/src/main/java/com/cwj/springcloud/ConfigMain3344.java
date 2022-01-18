package com.cwj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigMain3344 {
    public static void main(String[] args) {
        //http://localhost:3344/main/config-dev.yml  main是分支名称
        //http://localhost:3344/config/dev/main
        //curl -X POST "http://localhost:3344/actuator/bus-refresh" 通知配置中心刷新
        //curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355" 微服务名:端口 定向通知
        SpringApplication.run(ConfigMain3344.class, args);
    }
}
