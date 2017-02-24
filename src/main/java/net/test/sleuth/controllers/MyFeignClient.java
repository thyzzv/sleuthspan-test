package net.test.sleuth.controllers;

import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.cloud.sleuth.instrument.web.client.feign.DefaultFeignClientConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="myFeignClient", url="localhost:8080")
public interface MyFeignClient {

    @RequestMapping(value = "/service/ok/{param}", method = RequestMethod.GET)
    public String ok(@PathVariable("param") String param);
}
