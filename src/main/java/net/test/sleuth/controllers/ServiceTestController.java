package net.test.sleuth.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
@RequestMapping(path = "/service")
public class ServiceTestController {

    private final SpanAccessor spanAccessor;

    @Autowired
    ServiceTestController(SpanAccessor spanAccessor){
        this.spanAccessor = spanAccessor;
    }
    @RequestMapping(value = "/ok/{param}", method = RequestMethod.GET)
    public String ok(@PathVariable("param") String param, HttpServletRequest request) throws InterruptedException, ExecutionException {
        log.info("X-Span-Name: {} ", request.getHeader("X-Span-Name"));
        String result = "I'm OK " + param;
        return result;
    }
}
