package ru.clevertec.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.aspect.PerformanceMonitorAspect;

@Configuration
@ConditionalOnProperty(prefix = "performance.monitor", name = "enabled", havingValue = "true", matchIfMissing = true)
public class PerformanceMonitorAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public PerformanceMonitorAspect performanceMonitorAspect(PerformanceMonitorProperties properties) {
        return new PerformanceMonitorAspect(properties);
    }
}
