package com.cwj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cwj.springcloud.entities.CommonResult;
import com.cwj.springcloud.entities.Payment;
import com.cwj.springcloud.myhandler.CustmorHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {
    @GetMapping("/testa")
    public String testA() {
        return "-----testA";
    }

    @GetMapping("/testb")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_hotkey")
    public String testC(@RequestParam(value = "p1", required = false) String p1,
                        @RequestParam(value = "p2", required = false) String p2) {
        return "------testB";
    }

    public String deal_hotkey(String p1, String p2, BlockException be){
        return "--------------------deal_hotkey";
    }

    @GetMapping("/ratelimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustmorHandler.class,
            blockHandler = "handlerException1",
            fallback = "fallbackFunc")
    public CommonResult customerBlockHandler() {

        return new CommonResult(200, "按客户自定义", new Payment(2020L,"serial001"));
    }

    public CommonResult fallbackFunc() {
        return new CommonResult(444, "fallback兜底方法");
    }
}
