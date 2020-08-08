package com.unittest.UnitTesting.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessStubTest {

    @Test
    public void calculateSumNumbersUsingSomeService(){
        SomeBusinessImple businessImple = new SomeBusinessImple();
        businessImple.setDataService(new SomeBusinessStubImple());
        int sum = businessImple.sumNumbersUsingSomeService();
        assertEquals(15,sum);
    }

}
