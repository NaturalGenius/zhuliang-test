package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.util.StringUtils;

import com.example.demo.BaseTest;
import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;

public class PersonServiceTest extends BaseTest{

    @Mock
    private PersonMapper personMapper;
    @InjectMocks
    private PersonServiceImpl personService;
    
    @Test
    void savePersonBaseTest() {
        Person person = new Person("张三", 10);
        int savePerson = personService.savePerson(person);
        assertEquals(savePerson, 0);
    }
    @Test
    void savePersonStubTest() {
        Person person = new Person("张三", 10);
        when(personMapper.getPerson(1)).thenReturn(person);
        assertEquals(personMapper.getPerson(1), person);
    }
    
    @Test
    void savePersonTest() {
        Person person = new Person("张三", 10);
        when(personMapper.savePerson(person)).thenReturn(1);
        int savePerson = personService.savePerson(person);
        System.out.println(savePerson);
        verify(personMapper).savePerson(person);
        verify(personMapper, times(1)).savePerson(person);
        personService.savePerson(person);
        verify(personMapper, times(2)).savePerson(person);
    }
    
    @ParameterizedTest
    @MethodSource("personProvider")
    void testWithPersionMethodSource(Person person) {
        when(personMapper.savePerson(person)).thenReturn(1);
        int savePerson = personService.savePerson(person);
        System.out.println(savePerson);
        verify(personMapper).savePerson(person);
    }

    static Stream<Person> personProvider() {
        return Stream.of(new Person("张三", 10), new Person("李四", 10));
    }
    
}
