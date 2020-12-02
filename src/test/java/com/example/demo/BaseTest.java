package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseTest {
    
    @BeforeEach
    public void setUp() throws Exception {
       MockitoAnnotations.initMocks(this);
    }
}
