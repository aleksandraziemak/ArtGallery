package com.artgallery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("e2e")
public class MockRestServiceServerConfig {

    @Bean
    public MockRestServiceServer mockRestServiceServer(RestTemplate restTemplate) {
        return MockRestServiceServer.createServer(restTemplate);
    }
}
