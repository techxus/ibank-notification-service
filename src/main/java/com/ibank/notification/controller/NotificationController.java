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
@RequestMapping("/api/notification")
@Slf4j
public class NotificationController {

    private static final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/")
    public Map<String, Object> hello() {

        int counterValue = counter.incrementAndGet();
        String correlationId = UUID.randomUUID().toString();
        MDC.put("correlationId", correlationId);
        log.info("Processing GET:/api/notification...");

        return Map.of(
                "message", "Processing GET:/api/notification...",
                "timestamp", Instant.now().toString(),
                "counter", counterValue
        );
    }
}