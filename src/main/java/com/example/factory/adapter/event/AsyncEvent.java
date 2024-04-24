package com.example.factory.adapter.event;

import org.springframework.context.ApplicationEvent;

public class AsyncEvent extends ApplicationEvent {
    public AsyncEvent(Object source) {
        super(source);
    }
}
