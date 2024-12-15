package ru.clevertec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.service.TestService;

@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;
    @Test
    public void testAspect() throws InterruptedException {
        testService.performTask();
    }
}