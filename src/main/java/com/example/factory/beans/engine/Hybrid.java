package com.example.factory.beans.engine;

public class Hybrid implements Engine{

    Integer power;
    Boolean isEnabled = false;

    public Hybrid() {
        power = 300;
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
