package com.example.productservice_wfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductServiceWfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceWfsApplication.class, args);
    }

    @Bean
    public RestTemplateBuilder getRestTemplate() {
        return new RestTemplateBuilder();
    }
}
