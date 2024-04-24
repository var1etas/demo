package com.example.factory.adapter.event;

import org.springframework.context.ApplicationEvent;

public class SyncEvent extends ApplicationEvent {
    public SyncEvent(Object source) {
        super(source);
    }
}
