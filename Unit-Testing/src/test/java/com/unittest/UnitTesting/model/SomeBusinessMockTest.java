package com.unittest.UnitTesting.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {
    @InjectMocks
    SomeBusinessImple businessImple = new SomeBusinessImple();
    /* Old way to mock object without Annotation
    SomeDataService mockDataService = mock(SomeDataService.class);

    @BeforeEach
    public void before(){
        businessImple.setDataService(mockDataService);
    }
     */
    @Mock
    SomeDataService mockDataService;

    @Test
    public void calculateSumNumbersUsingSomeService(){
        when(mockDataService.retrieveAllData()).thenReturn(new int[]{1,2});

        assertEquals(3,businessImple.sumNumbersUsingSomeService());
    }
    @Test
    public void calculateSumNumbersUsingSomeServiceEmpty(){
        when(mockDataService.retrieveAllData()).thenReturn(new int[]{});

        assertEquals(0,businessImple.sumNumbersUsingSomeService());
    }

}
