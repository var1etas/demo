package com.example.factory.adapter.web;

import com.example.factory.service.Publisher;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/event")
public class EventController {
    Publisher publisher;

    @RequestMapping("/sync")
    public void publishSyncEvent() {
        publisher.publishSyncEvent();
    }

    @RequestMapping("/async")
    public void publishAsyncEvent() {
        publisher.publishAsyncEvent();
    }

    @RequestMapping("/transactional")
    public void publishTransactionalEvent() {
        publisher.publishTransactionalEvent();
    }

}
