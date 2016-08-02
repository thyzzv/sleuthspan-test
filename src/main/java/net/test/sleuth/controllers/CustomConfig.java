package net.test.sleuth.controllers;

import feign.Response;
import feign.RetryableException;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Configuration
public class CustomConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }

    public static class CustomErrorDecoder extends ErrorDecoder.Default {

        public CustomErrorDecoder() {
        }

        @Override
        public Exception decode(String methodKey, Response response) {
            if (response.status() == 409) {
                return new RetryableException("Article not Ready", new Date());
            } else {
                return super.decode(methodKey, response);
            }
        }

    }
}
