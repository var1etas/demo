package com.example.factory.config;


import com.example.factory.beans.engine.ElectricEngine;
import com.example.factory.beans.engine.Engine;
import com.example.factory.beans.engine.GasEngine;
import com.example.factory.beans.engine.Hybrid;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
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
