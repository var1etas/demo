package com.example.factory.beans.engine;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
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
}
