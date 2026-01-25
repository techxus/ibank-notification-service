package com.ibank.notification.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.MDC;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping
@Slf4j
public class NotificationController {

    private static final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/server")
    public Map<String, Object> getServerDetails() {

        int counterValue = counter.incrementAndGet();
        String correlationId = UUID.randomUUID().toString();
        MDC.put("correlationId", correlationId);
        log.info("Processing GET:/api/v1/notification/server...");

        return Map.of(
                "message", "Brick @ Postgres | Redis | Vault Setup Milestone Reached !!!",
                "timestamp", Instant.now().toString(),
                "counter", counterValue
        );
    }
}