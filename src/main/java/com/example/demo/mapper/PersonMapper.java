package com.example.demo.mapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
public class PersonMapper {

    private Map<Integer, Person> dbMap  = new ConcurrentHashMap<>();
    private AtomicInteger idAtomicInteger  = new AtomicInteger(1);
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    public int savePerson(Person person) {
        logger.info("savePerson name:{}", person.getName());
        int id = idAtomicInteger.getAndIncrement();
        dbMap.put(id, person);
        return id;
    }
    
    
    public Person getPerson(Integer id) {
        logger.info("getPerson id:{}", id);
        return dbMap.get(id);
    }
}
