package com.example.factory.adapter.web;

import com.example.factory.adapter.web.errors.ErrorResponse;
import com.example.factory.adapter.web.errors.MethodNotAllowedException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/car/v1", produces = APPLICATION_JSON_VALUE)
public class HeadersController {

    @GetMapping("/head")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers){
        return headers;
    }

    @PostMapping("/head")
    public ErrorResponse getException() throws MethodNotAllowedException{
        throw new MethodNotAllowedException();
    }
}