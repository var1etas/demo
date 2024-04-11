package com.example.factory.controller;

import com.example.factory.model.dto.EventsDto;
import com.example.factory.service.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping(value = "/event")
@RequiredArgsConstructor
public class EventController {

    private final EventsService eventsService;

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void addEvents(@RequestBody EventsDto todo) {
        eventsService.save(todo);
    }

    @GetMapping(value = "/get", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody List<EventsDto> getEvents() {
        return eventsService.get();
    }

}
