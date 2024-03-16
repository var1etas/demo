package com.example.factory.adapter.web;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = "/api/car/v1", produces = APPLICATION_JSON_VALUE)
public class HeadersController {

    @GetMapping("/head")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers){
        return headers;
    }
}
