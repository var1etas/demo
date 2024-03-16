package com.example.factory.service;

import com.example.factory.adapter.web.dto.Order;
import com.example.factory.service.common.Worker;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DeliveryService {

    @Autowired
    Worker worker;

    public void deliverOrder(Long orderId) {
        worker.addJob(() -> {
            log.info("Start delivering order with id {}", orderId);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.info("End delivering order with id {}", orderId);
        });
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Delivery service created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Delivery service destroyed");
    }

}
