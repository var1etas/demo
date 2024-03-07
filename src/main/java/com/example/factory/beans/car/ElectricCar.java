package com.example.factory.beans.car;

import com.example.factory.beans.engine.Engine;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ElectricCar implements Car{

    private final Engine engine;

    public ElectricCar(@Qualifier(value = "electricEngine") Engine engine) {
        this.engine = engine;
    }

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
