package com.example.factory.service;

import com.example.factory.adapter.web.dto.OrderIn;
import com.example.factory.adapter.web.dto.OrderOut;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class OrderService{
    public OrderOut addId(OrderIn order){
        Long orderId = Math.abs(new Random().nextLong());
        return new OrderOut(order.price(), new OrderOut.Info(orderId, order.info().date()));
    }
}
