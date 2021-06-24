package com.cwj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //开启RestTemplate负载均衡，能通过服务名称找到服务提供者，不加此注解，通过http://CLOUD-PAYMENT-SERVICE访问会报错
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
