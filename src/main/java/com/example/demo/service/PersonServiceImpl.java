package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;

@Service
public class PersonServiceImpl implements PersonService{

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PersonMapper personMapper;
    @Override
    public int savePerson(Person person) {
        logger.info("savePerson name:{}", person.getName());
        return personMapper.savePerson(person);
    }

    @Override
    public Person getPerson(Integer id) {
        logger.info("getPerson id:{}", id);
        return personMapper.getPerson(id);
    }

}
