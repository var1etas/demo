package com.example.factory.adapter.web;

import com.example.factory.adapter.web.dto.OrderIn;
import com.example.factory.adapter.web.dto.OrderOut;
import com.example.factory.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/car/v1", produces = APPLICATION_JSON_VALUE,  consumes="application/json")
@RequiredArgsConstructor
public class JsonController {

    private final OrderService orderService;

    @PostMapping("/jsonOrder")
    public @ResponseBody OrderOut getJsonOrder(@RequestBody OrderIn order){
        return orderService.addId(order);
    }
}
