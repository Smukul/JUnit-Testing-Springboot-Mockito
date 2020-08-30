package com.unittest.UnitTesting;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HamcrestMatchersTest {
    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,45,56,89);

        assertThat(numbers,hasSize(4));
        assertThat(numbers,hasItem(45));
        assertThat(numbers,hasItems(45,12));
        assertThat(numbers,everyItem(greaterThan(10)));
        assertThat(numbers,everyItem(lessThan(150)));

        assertThat("",isEmptyString());
        assertThat("ABCD",containsString("CD"));
        assertThat("ABCDF",startsWith("AB"));
        assertThat("EDFRTGB",endsWith("TGB"));
    }
}
