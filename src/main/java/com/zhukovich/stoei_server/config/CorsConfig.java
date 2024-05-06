package com.zhukovich.stoei_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        var urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        var corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Content-Type", "userId"));
        corsConfiguration.setExposedHeaders(List.of("Access-Control-Allow-Origin"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}