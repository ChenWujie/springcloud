package com.cwj.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 通过对Feign接口实现的方法
 * 重写的方法即fallback的方法
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "提供方服务器出现故障";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return null;
    }
}
