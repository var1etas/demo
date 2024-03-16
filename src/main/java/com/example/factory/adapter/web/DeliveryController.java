package com.example.factory.adapter.web;

import com.example.factory.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/car/v1", produces = APPLICATION_JSON_VALUE)
public class DeliveryController {

    DeliveryService deliveryService;

    @PostMapping("/deliver/{orderId}")
    public void deliverOrder(@PathVariable Long orderId) {
        deliveryService.deliverOrder(orderId);
    }

}
