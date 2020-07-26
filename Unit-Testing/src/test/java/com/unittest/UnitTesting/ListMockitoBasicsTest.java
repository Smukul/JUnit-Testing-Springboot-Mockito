package com.unittest.UnitTesting;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockitoBasicsTest {
    private List<String> mock = Mockito.mock(List.class);
    @Test
    public void listTest(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParameterTest(){
        when(mock.get(0)).thenReturn("Pratap").thenReturn("10");
        assertEquals("Pratap",mock.get(0));
        assertEquals("10",mock.get(0));
    }

    @Test
    public void returnWithGenericParameterTest(){
        when(mock.get(anyInt())).thenReturn("13").thenReturn("10");
        assertEquals("13",mock.get(0));
        assertEquals("10",mock.get(1));
    }

    @Test
    public void verificationBasic(){
        String s = mock.get(0);
        //
        verify(mock).get(0);
        verify(mock).get(anyInt());
        verify(mock,times(1)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atMost(1)).get(anyInt());
        verify(mock,never()).get(3);
    }

    @Test
    public void argumentCapturing(){
        //SUT
        mock.add("SomeString");
        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString",captor.getValue());
    }
    @Test
    public void multipleArgumentCapturing(){
        //SUT
        mock.add("SomeString");
        mock.add("String");
        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());
        List<String> allCapture = captor.getAllValues();
        assertEquals("SomeString",allCapture.get(0));
        assertEquals("String",allCapture.get(1));
    }

    @Test
    public void mockingTest(){
        ArrayList arrayListMock = Mockito.mock(ArrayList.class);
        System.out.println(arrayListMock.get(0));; //null
        System.out.println(arrayListMock.size());; // 0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());; // 2
        when(arrayListMock.size()).thenReturn(5);
        assertEquals(5,arrayListMock.size());
    }
    @Test
    public void spyingTest(){
        //We used spy() to act class as actual
        ArrayList arrayListMock = spy(ArrayList.class);
        arrayListMock.add("Test1");
        System.out.println(arrayListMock.get(0));; //null
        System.out.println(arrayListMock.size());; // 0

        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());; // 2
        when(arrayListMock.size()).thenReturn(5);
        assertEquals(5,arrayListMock.size());
    }
}
