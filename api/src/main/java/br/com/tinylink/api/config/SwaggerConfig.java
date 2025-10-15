package br.com.tinylink.api.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SwaggerConfig {
    @Bean
    @Primary
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("api") 
                .packagesToScan("br.com.tinylink.api.controllers")
                .build();
    }
}