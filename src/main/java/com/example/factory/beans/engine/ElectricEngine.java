package com.example.factory.beans.engine;

import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine {

    Integer power;
    boolean enabled = false;

    public ElectricEngine() {
        power = 50;
    }

    public void start() {
        enabled = true;
    }

    public void stop() {
        enabled = false;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public int getPower() {
        return power;
    }
}
