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

    static String BIG_STRING;

    {
        StringBuilder tempBigString = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            tempBigString.append("value_").append(i).append(",");
        }
        BIG_STRING = tempBigString.toString();
    }


    @Autowired
    private MyFeignClient myFeignClient;

    @RequestMapping("/test-ok")
    public String ok() throws InterruptedException, ExecutionException {
        String result = myFeignClient.ok(BIG_STRING);
        log.info("Showing result {}", result);
        return result;
    }


}
