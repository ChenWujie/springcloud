package com.cwj.springcloud.controller;

import com.cwj.springcloud.entities.CommonResult;
import com.cwj.springcloud.entities.Payment;
import com.cwj.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalance loadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        URI PAYMENT_URL = getUri();
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        URI PAYMENT_URL = getUri();
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery() {
        URI PAYMENT_URL = getUri();
        return restTemplate.getForObject(PAYMENT_URL + "/payment/discovery", Object.class);
    }

    @GetMapping("/consumer/payment/getforentity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        URI PAYMENT_URL = getUri();
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        URI PAYMENT_URL = getUri();
        System.out.println("uri---" + PAYMENT_URL);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/lb", String.class);
    }

    /**
     * 调用此方法，通过自定义的轮询算法实现负载均衡
     * @return
     */
    public URI getUri() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if(instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        System.out.println(uri + " ===========");
        return uri;
    }
}
