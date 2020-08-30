package com.unittest.UnitTesting;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class AssertJTest {
    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,45,56,89);

        assertThat(numbers).hasSize(4);
        assertThat(numbers).contains(45,12);
        assertThat(numbers).allMatch(x->x>10); //every element greater than 10
        assertThat(numbers).allMatch(x->x<100);//every element less than 100


        assertThat("").isEmpty();
        assertThat("ABCD").contains("BC");
        assertThat("ABCDF").startsWith("AB");
        assertThat("EDFRTGB").endsWith("TGB");
    }
}
