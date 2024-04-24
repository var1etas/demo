package com.example.factory.domain;

import com.example.factory.config.APIConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
@RequiredArgsConstructor
public class LimitAspect {

    private final APIConfig apiConfig;
    int count = 0;

    @Before("@annotation(com.example.factory.domain.Limited)")
    public void requestLimit() {
        count++;
        log.info("Requests from one user: " + count);
        if (count > apiConfig.getLimit()) {
            throw new RuntimeException("Too many requests");
        }
    }
}
