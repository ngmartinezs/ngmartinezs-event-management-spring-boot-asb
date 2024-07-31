package com.ngmartinezs.wsmscuentaappjava;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ngmartinezs.wsmscuentaappjava.messaging.MessageService;

@Component
public class ApplicationStartupListener {

    @Qualifier("MessageServiceBusCreaCliente")
    @Autowired
    private MessageService messageService;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        messageService.startMessageListener();
    }

    @EventListener(ContextClosedEvent.class)
    public void stop() {
        messageService.stopMessageListener();
    }
}
