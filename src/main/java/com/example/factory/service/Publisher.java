package com.example.factory.service;


import com.example.factory.adapter.event.AsyncEvent;
import com.example.factory.adapter.event.SyncEvent;
import com.example.factory.adapter.event.TransactionalEvent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Publisher {
    ApplicationEventPublisher eventPublisher;

    public void publishSyncEvent() {
        SyncEvent event = new SyncEvent(this);
        eventPublisher.publishEvent(event);
        log.info("Sync event triggered");
    }

    public void publishAsyncEvent() {
        AsyncEvent event = new AsyncEvent(this);
        eventPublisher.publishEvent(event);
        log.info("Async event triggered");
    }

    @Transactional(rollbackFor = Exception.class)
    public void publishTransactionalEvent() {
        TransactionalEvent event = new TransactionalEvent(this);
        TransactionalEvent unhandledEvent = new TransactionalEvent(this);
        eventPublisher.publishEvent(event);
        log.info("Transactional event triggered");

        try {
            eventPublisher.publishEvent(unhandledEvent);
            throw new RuntimeException("Transactional event not processed");
        } catch (RuntimeException exception) {
            log.error(exception);
        }
    }
}
