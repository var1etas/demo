package com.example.factory.beans.car;

import com.example.factory.beans.engine.Engine;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GasolineCar implements Car {

    @Autowired
    Engine gasEngine;

    @PostConstruct
    public void postConstruct() {
        gasEngine.start();
        log.info("Engine in car enabled: {}", gasEngine.isEnabled());
        log.info("Power: {}", gasEngine.getPower());
    }

    @PreDestroy
    public void preDestroy(){
        gasEngine.stop();
        log.info("Engine in car enabled: {}", gasEngine.isEnabled());
    }
}
