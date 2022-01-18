package com.cwj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    //http://localhost:3355/configInfo
    // 修改github上的配置文件后，配置中心3344立刻做出改变，但客户端3355不会立刻改变
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "serverport: " + serverPort + "\n\n" + configInfo;
    }
}
