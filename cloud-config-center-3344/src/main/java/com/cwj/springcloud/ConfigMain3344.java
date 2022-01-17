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
        SpringApplication.run(ConfigMain3344.class, args);
    }
}
