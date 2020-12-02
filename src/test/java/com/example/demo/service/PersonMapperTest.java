package com.example.demo.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;
    
//    @Test
//    public void savePersonTest() {
//        assertEquals(personMapper.savePerson(new Person("掌声", 11)), 1);
//    }
    
    @RepeatedTest(value = 10)
    public void savePersonRepeated(RepetitionInfo repetitionInfo) {
        assertEquals(personMapper.savePerson(new Person("掌声", 11)), repetitionInfo.getCurrentRepetition());
    }
    
}
