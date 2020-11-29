package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.demo.entity.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

//@ExtendWith(MockitoExtension.)
public class MyMockitoTest {
    
    
    @BeforeEach
    void init(@Mock Person person) {
     when(person.getName()).thenReturn("Dilbert");
    }
    
    @Test
    void simpleTestWithInjectedMock(@Mock Person person) {
    assertEquals("Dilbert", person.getName());
    }
}
