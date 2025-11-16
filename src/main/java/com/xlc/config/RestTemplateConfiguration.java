package com.xlc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @LoadBalanced
    @Bean
    // todo sentinel need to support GraalVM in future
//	@SentinelRestTemplate(urlCleanerClass = UrlCleaner.class, urlCleaner = "clean")
    public RestTemplate urlCleanedRestTemplate() {
        return new RestTemplate();
    }

    @LoadBalanced
    @Bean
    // todo sentinel need to support GraalVM in future
//	@SentinelRestTemplate
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}