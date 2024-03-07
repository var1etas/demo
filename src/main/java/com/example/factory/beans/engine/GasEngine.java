package com.example.factory.beans.engine;

import org.springframework.stereotype.Component;

@Component
public class GasEngine implements Engine{

    Integer power;
    boolean enabled = false;

    public GasEngine() {
        power = 250;
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
