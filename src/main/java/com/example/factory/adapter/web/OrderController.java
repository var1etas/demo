package com.example.factory.adapter.web;

import com.example.factory.adapter.web.dto.CompositionIn;
import com.example.factory.adapter.web.dto.Order;
import com.example.factory.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = "/api/car/v1", produces = APPLICATION_JSON_VALUE)
public class OrderController {

    OrderService orderService;

    @PostMapping("/order")
    public Long createOrder(@RequestBody CompositionIn composition) {
        return orderService.createOrder(composition);
    }

    @DeleteMapping("/order/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.removeOrder(orderId);
    }

    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable("orderId") Long orderId) throws NameNotFoundException {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/order")
    public Map<Long, String> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/head")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers){
        return headers;
    }
}
