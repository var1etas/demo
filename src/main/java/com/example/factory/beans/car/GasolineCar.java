package com.example.factory.beans.car;

import com.example.factory.beans.engine.Engine;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GasolineCar implements Car {

    @Autowired
    @Qualifier(value = "gasEngine")
    private Engine engine;

    @PostConstruct
    public void postConstruct() {
        engine.start();
        System.out.printf("Engine in car enabled: %s%n", engine.getIsEnabled());
        System.out.println(engine.getPower());
    }

    @PreDestroy
    public void preDestroy(){
        engine.stop();
        System.out.printf("Engine in car enabled: %s%n", engine.getIsEnabled());
    }
}
