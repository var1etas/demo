package com.example.factory.beans;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BeanThree {
    @PostConstruct
    public void create() {
        log.info("Bean three created");
    }
}
