package com.example.factory.adapter.web;

import com.example.factory.domain.Limited;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/aspect")
public class EventController {
    @Limited
    @RequestMapping("/limit")
    public void limitedRequest() {
    }
}
