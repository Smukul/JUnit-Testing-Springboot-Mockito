package com.unittest.UnitTesting.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SomeBusinessTest {

    @Test
    public void calculateSum(){
        SomeBusinessImple businessImple = new SomeBusinessImple();
        int sum = businessImple.sumNumbers(new int[]{1,2,3});
        assertEquals(6,sum);
    }
    @Test
    public void calculateSumEmptyArray(){
        SomeBusinessImple businessImple = new SomeBusinessImple();
        int sum = businessImple.sumNumbers(new int[]{});
        assertEquals(0,sum);
    }
}
