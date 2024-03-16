package com.example.factory.config;

import com.example.factory.service.common.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WorkerConfig {
    @Bean
    @Scope(value = "prototype")
    public Worker worker() {
        Worker worker = new Worker();
        worker.startWork();
        return worker;
    }
}
