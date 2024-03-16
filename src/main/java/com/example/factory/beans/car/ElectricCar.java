package com.example.factory.beans.car;

import com.example.factory.beans.engine.Engine;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ElectricCar implements Car{

    Engine electricEngine;

    @PostConstruct
    public void postConstruct() {
        electricEngine.start();
        log.info("Engine in car enabled: {}", electricEngine.isEnabled());
        log.info("Power: {}", electricEngine.getPower());
    }

    @PreDestroy
    public void preDestroy(){
        electricEngine.stop();
        log.info("Engine in car enabled: {}", electricEngine.isEnabled());
    }
}
