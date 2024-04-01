package com.example.factory.configuration.property;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@Log4j2
@ConfigurationProperties(prefix = "spring.application")
public class ApplicationProperties {
    private List<Object> property;

    @PostConstruct
    public void create() {
        log.info(property);
    }
}
