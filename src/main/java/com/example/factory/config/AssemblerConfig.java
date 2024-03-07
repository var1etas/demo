package com.example.factory.config;

import com.example.factory.beans.engine.ElectricEngine;
import com.example.factory.beans.engine.Engine;
import com.example.factory.beans.engine.GasEngine;
import com.example.factory.beans.engine.Hybrid;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AssemblerConfig {

    @Bean
    public Engine gasEngine() {
        return new GasEngine();
    }

    @Bean
    public Engine electricEngine() {
        return new ElectricEngine();
    }

    @Bean
    public Engine hybrid() {
        return new Hybrid();
    }
}
