package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class Publisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueProprietario;

    @Scheduled(fixedDelay = 1000)
    void publishMessage() {
        var message = """
                "location": {
                        "street": "3476 Tyrell Plain",
                        "city": "East Websterfield",
                        "state": "Kentucky",
                        "country": "Timor-Leste",
                        "zip": "56540",
                        "coordinates": {
                          "latitude": -26.9851,
                          "longitude": 23.2366
                        }
                """;
        rabbitTemplate.convertAndSend(queueProprietario.getName(), message);
        log.info("[x] Sent a message...thread{}", Thread.currentThread().getName());
    }

}
