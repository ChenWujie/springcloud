package com.cwj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //实现手动刷新配置，向3355端口发送Post请求后即可刷新：curl -X POST "http://localhost:3355/actuator/refresh"
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    //http://localhost:3355/configInfo
    // 修改github上的配置文件后，配置中心3344立刻做出改变，但客户端3355不会立刻改变
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
