package com.example.factory.adapter.web;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = "/api/car/v1", produces = APPLICATION_JSON_VALUE,  consumes="application/json")
public class JsonController {

    @PostMapping("/jsonOrder")
    public @ResponseBody Map<String, Object> getJsonOrder(@RequestBody Map<String, Object> jsonOrder){
        Long orderId = Math.abs(new Random().nextLong());
        Map date = (Map)jsonOrder.get("info");
        jsonOrder.remove("info");
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("id", orderId);
        info.put("date", date.get("date"));
        jsonOrder.put("info", info);
        return jsonOrder;
    }
}
