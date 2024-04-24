package com.example.factory.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class APIConfig {
    @Value("${api.limit}")
    int limit;
}
