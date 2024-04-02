package com.example.factory.adapter.web;

import com.example.factory.adapter.web.dto.OrderIn;
import com.example.factory.adapter.web.dto.OrderOut;
import com.example.factory.service.OrderService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/car/v1", produces = APPLICATION_JSON_VALUE,  consumes="application/json")
public class JsonController {

    @PostMapping("/jsonOrder")
    public @ResponseBody OrderOut getJsonOrder(@RequestBody OrderIn order){
        return new OrderService().addId(order);
    }
}
