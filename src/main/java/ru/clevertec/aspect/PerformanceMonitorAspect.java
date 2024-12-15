package ru.clevertec.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.clevertec.config.PerformanceMonitorProperties;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class PerformanceMonitorAspect {
    private final PerformanceMonitorProperties performanceMonitorProperties;

    @Pointcut("@annotation(ru.clevertec.annotation.MonitorPerformance)")
    public void monitorPerformance() {
    }

    @Around("monitorPerformance()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!performanceMonitorProperties.isEnabled()) {
            return joinPoint.proceed();
        }
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;

        if (executionTime >= performanceMonitorProperties.getMinExecutionTime()) {
            String methodName = joinPoint.getSignature().toShortString();
            log.info("Method [%s] executed in [%d ms]%n", methodName, executionTime);
        }
        return result;
    }

}
