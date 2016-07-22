package net.test.sleuth.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
@RequestMapping(path = "/sleuth")
public class SleuthTestController {

    @Autowired
    private MyFeignClient myFeignClient;

    @RequestMapping("/test-ok")
    public String ok() throws InterruptedException, ExecutionException {
        String result = myFeignClient.ok();
        return result;
    }

    @RequestMapping("/test-not-ok")
    public String notOk() throws InterruptedException, ExecutionException {
        String result = myFeignClient.exp();
        return result;
    }
}
