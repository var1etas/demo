package com.example.factory.adapter.eventlistener;

import com.example.factory.adapter.event.AsyncEvent;
import com.example.factory.adapter.event.SyncEvent;
import com.example.factory.adapter.event.TransactionalEvent;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;


@Service
@Log4j2
public class EventsListener {

    @EventListener
    public void basicEventListener(SyncEvent event) {
        log.info("Sync event processed");
    }

    @EventListener
    @SneakyThrows
    @Async
    public void asyncEventListener(AsyncEvent event) {
        Thread.sleep(5000);
        log.info("Async event processed");
    }

    @TransactionalEventListener
    public void transactionalEventListener(TransactionalEvent event) {
        log.info("Transactional event processed");
    }
}
