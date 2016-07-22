package net.test.sleuth.app;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import net.test.sleuth.controllers.SleuthTestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication(scanBasePackageClasses = {SleuthTestController.class} )
@EnableFeignClients(basePackageClasses = {SleuthTestController.class})
public class Application {


    public static void main(String[] args) throws Exception{
        ApplicationContext ctx =  SpringApplication.run(Application.class, args);
        RestTemplate template = new TestRestTemplate();
        String securedURl = "http://localhost:8080/sleuth/test-ok";
        ResponseEntity<String> response = template.getForEntity(securedURl, String.class);
        log.info("Response was: {}", response);

        securedURl = "http://localhost:8080/sleuth/test-not-ok";
        response = template.getForEntity(securedURl, String.class);
        log.info("Response was: {}", response);

        System.exit(0);
    }



    @Bean
    public Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
