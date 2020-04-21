package com.liuff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class, args);
    }

    /**
     * 向Spring容器中定义RestTemplate对象
     * 
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
