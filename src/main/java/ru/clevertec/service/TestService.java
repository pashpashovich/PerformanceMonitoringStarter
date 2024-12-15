package ru.clevertec.service;

import org.springframework.stereotype.Component;
import ru.clevertec.annotation.MonitorPerformance;

@Component
public class TestService {
    @MonitorPerformance
    public void performTask() throws InterruptedException {
        Thread.sleep(200);
    }
}