package com.example.factory.beans.engine;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ElectricEngine implements Engine{

    Integer power;
    Boolean isEnabled = false;

    public ElectricEngine() {
        power = 50;
    }

    public void start() {
        isEnabled = true;
    }

    public void stop() {
        isEnabled = false;
    }

    public boolean getIsEnabled(){
        return isEnabled;
    }

    public int getPower(){
        return power;
    }
}
