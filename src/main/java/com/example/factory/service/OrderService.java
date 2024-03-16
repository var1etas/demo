package com.example.factory.service;

import com.example.factory.adapter.web.dto.CompositionIn;
import com.example.factory.adapter.web.dto.Order;
import com.example.factory.service.common.Worker;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Log4j2
public class OrderService {

    @Autowired
    Worker worker;
    @Getter
    Map<Long, String> orders = new ConcurrentHashMap<>();

    @Autowired
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Long createOrder(CompositionIn composition) {
        Long orderId = new Random().nextLong();
        orders.put(orderId, composition.composition());
        worker.addJob(() -> {
            log.info("Start creating order with id {}", orderId);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("End creating order with id {}", orderId);
        });
        return orderId;
    }

    public Order getOrder(Long orderId) throws NameNotFoundException {
        if (!orders.containsKey(orderId)) {
            throw new NameNotFoundException();
        }
        return new Order(orderId, orders.get(orderId));
    }

    public void removeOrder(Long orderId) {
        orders.remove(orderId);
    }
}
