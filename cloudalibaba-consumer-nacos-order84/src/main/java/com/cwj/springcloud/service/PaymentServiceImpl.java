package com.cwj.springcloud.service;

import com.cwj.springcloud.entities.CommonResult;
import com.cwj.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444, "OpenFeign服务降级方法");
    }
}
