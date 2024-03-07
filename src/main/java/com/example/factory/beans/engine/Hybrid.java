package com.example.factory.beans.engine;

import org.springframework.stereotype.Component;

@Component
public class Hybrid implements Engine{

    Integer power;
    boolean enabled = false;

    public Hybrid() {
        power = 300;
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

    public int getPower(){
        return power;
    }
}
