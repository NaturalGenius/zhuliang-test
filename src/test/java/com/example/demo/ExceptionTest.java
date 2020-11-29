package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

//    @org.junit.Test(expected = RuntimeException.class)
//    public void testThrowsException() throws Exception {
//        throw new RuntimeException();
//    }
//    
    @Test
    @DisplayName("testThrowsException2...")
    void testThrowsException2() throws Exception {
        Assertions.assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException();
        });
    }
}
