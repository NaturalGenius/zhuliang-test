package com.example.demo;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class TimeoutTest {

    @Test(timeout = 100)
    public void testFailWithTimeout() throws InterruptedException {
        Thread.sleep(100);
    }
    
    @org.junit.jupiter.api.Test
    void testFailWithTimeout2() throws InterruptedException {
        Assertions.assertTimeout(Duration.ofMillis(10), () -> Thread.sleep(100));
    }
}
