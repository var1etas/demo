package com.example.factory.beans.engine;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
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
}
