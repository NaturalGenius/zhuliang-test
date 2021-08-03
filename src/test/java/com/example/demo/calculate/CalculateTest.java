package com.example.demo.calculate;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("CalculateTest ....")
public class CalculateTest {
    
    @BeforeAll
    public static void beforeClass() {
        System.out.println("start test........");
    }
    @BeforeEach
    public  void beforeTest() {
        System.out.println("beforeTest........");
    }
    
    @Test
    @DisplayName("testAdd")
    @Disabled
    public void testAdd(){
        System.out.println("testAdd........");
        assertEquals(6,new Calculate().add(3, 3));
    }
    
    @Test
    @DisplayName("testsubstractdddddddddddddddd")
    void testsubstract(){
        System.out.println("testsubstract........");
        assertEquals(2,new Calculate().substract(5, 3));
    }
    
    @Test
    @DisplayName("testcheng")
    @Disabled
    public void testcheng(){
        System.out.println("testcheng........");
        assertEquals(15,new Calculate().cheng(5, 3));
    }
    @Test
    @DisplayName("testch")
    void testchu(){
        System.out.println("朱亮哈");
        assertEquals(2,new Calculate().chu(6, 3));
    }
    @Test
    @DisplayName("testchu")
    void testException(){
        System.out.println("testchu........");
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
    
    @Nested
    class CalculateDemo {
        
        @AfterEach
        @DisplayName("afterCalculateDemo")
        public  void afterTest() {
            System.out.println("afterCalculateDemo........");
        }
        
        @Test
        @DisplayName("testCalculateDemo")
        public void testCalculateDemo(){
            System.out.println("testCalculateDemo........");
            assertEquals(6,new Calculate().add(3, 3));
        }
    }
    
}
