package com.cwj.springcloud.service;

import com.cwj.springcloud.entities.Payment;
import com.cwj.springcloud.mapper.PaymentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id) {
        return paymentMapper.getPaymentById(id);
    }
}


