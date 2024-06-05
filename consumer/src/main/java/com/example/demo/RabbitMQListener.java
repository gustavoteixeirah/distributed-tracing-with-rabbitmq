package com.example.demo;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RabbitMQListener implements MessageListener {

    @SneakyThrows
    public void onMessage(Message message) {
        log.info("[x] Received a message...thread {}", Thread.currentThread().getName());
        log.info("[x] waiting...");
        Thread.sleep(1000);
        log.info("[x] Finished waiting...");
    }
}
