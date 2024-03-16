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
public class HybridCar implements Car{

    Engine engine;

    @Autowired
    public void setEngine(Engine hybrid) {
        this.engine = hybrid;
    }

    @PostConstruct
    public void postConstruct() {
        engine.start();
        log.info("Engine in car enabled: {}", engine.isEnabled());
        log.info("Power: {}", engine.getPower());
    }

    @PreDestroy
    public void preDestroy(){
        engine.stop();
        log.info("Engine in car enabled: {}", engine.isEnabled());
    }
}
