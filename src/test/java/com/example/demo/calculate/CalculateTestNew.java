package com.example.demo.calculate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateTestNew {
    
    @BeforeAll
    public static void beforeClass() {
        System.out.println("start test........");
    }
    @BeforeEach
    public  void beforeTest() {
        System.out.println("beforeTest........");
    }
    
    @Test
    public void testAdd(){
        System.out.println(getClass().getName() + "testAdd");
        assertEquals(6,new Calculate().add(3, 3));
    }
    
    @Test
    public void testsubstract(){
        assertEquals(2,new Calculate().substract(5, 3));
    }
    
    @Test
    public void testcheng(){
        assertEquals(15,new Calculate().cheng(5, 3));
    }
    @Test
    public void testchu(){
        assertEquals(2,new Calculate().chu(6, 3));
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("end test........");
    }
    
    @AfterEach
    public  void afterTest() {
        System.out.println("afterTest........");
    }
    
}
