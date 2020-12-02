package com.example.demo.service;

import com.example.demo.entity.Person;

public interface PersonService {

    int savePerson(Person person);
    
    
    Person getPerson(Integer id);
}
