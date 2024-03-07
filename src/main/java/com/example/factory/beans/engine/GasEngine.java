package com.example.factory.beans.engine;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GasEngine implements Engine{

    Integer power;
    Boolean isEnabled = false;

    public GasEngine() {
        power = 250;
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
