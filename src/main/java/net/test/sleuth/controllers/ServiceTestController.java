package net.test.sleuth.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
@RequestMapping(path = "/service")
public class ServiceTestController {

    @RequestMapping("/ok")
    public String ok() throws InterruptedException, ExecutionException {
        String result = "I'm OK";
        return result;
    }

    @RequestMapping("/not-ok")
    @ResponseStatus(HttpStatus.CONFLICT)
    public String notOk() throws InterruptedException, ExecutionException {
        return "Not OK";
    }
}
