package ru.clevertec.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "performance.monitor")
public class PerformanceMonitorProperties {
    private boolean enabled = true;
    private long minExecutionTime = 0;
}
