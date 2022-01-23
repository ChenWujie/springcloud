package com.cwj.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cwj.springcloud.entities.CommonResult;
import com.cwj.springcloud.entities.Payment;

public class CustmorHandler {
    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "按客户自定义");
    }
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义");
    }
}
