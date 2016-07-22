package net.test.sleuth.controllers;

import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.cloud.sleuth.instrument.web.client.feign.DefaultFeignClientConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="myFeignClient", url="localhost:8080")
public interface MyFeignClient {
  
    @RequestMapping("/service/ok")
    public String ok();

    @RequestMapping("/service/not-ok")
    public String exp();
}
