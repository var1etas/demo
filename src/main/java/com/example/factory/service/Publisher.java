package com.example.factory.service;


import com.example.factory.adapter.event.AsyncEvent;
import com.example.factory.adapter.event.SyncEvent;
import com.example.factory.adapter.event.TransactionalEvent;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


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

    @Transactional
    public void publishTransactionalEvent() {
        TransactionalEvent event = new TransactionalEvent(this);
        log.info("Transactional event triggered");
        eventPublisher.publishEvent(event);
    }

    @Transactional(rollbackOn = Exception.class)
    public void publishUnhandledTransactionalEvent() {
        TransactionalEvent unhandledEvent = new TransactionalEvent(this);
        log.info("Transactional unhandled event triggered");
        eventPublisher.publishEvent(unhandledEvent);
        throw new RuntimeException("Transactional unhandled event not processed");
    }
}
