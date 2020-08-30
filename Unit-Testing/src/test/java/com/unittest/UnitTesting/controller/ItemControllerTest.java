package com.unittest.UnitTesting.controller;

import com.unittest.UnitTesting.business.ItemBusinessService;
import com.unittest.UnitTesting.model.Item;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(controllers = ItemController.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemBusinessService businessService;

    String expected  = "{\"id\":3,\"name\":\"Mock3\",\"price\":10,\"quantity\":2,\"value\":null}";

    @Test
    public void itemBusinessTest() throws Exception {
        when(businessService.retrieveHardCodedItem()).thenReturn(new Item(3,"Mock3",10,2));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-business")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result=  mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expected)) //as here we  added assertion so below one is optional
                .andReturn();
    }

    @Test
    public void itemTest() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result=  mockMvc.perform(request)
                .andExpect(status().isOk())
                //.andExpect(content().string(expected)) //as here we  added assertion so below one is optional
                .andReturn();
    }

    @Test
    public void jsonAssert_StrictTrue() throws JSONException {
        String actual  = "{\"id\":3,\"name\":\"Mock3\",\"price\":10,\"quantity\":2,\"value\":null}";
        JSONAssert.assertEquals(actual,expected,true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String actual  = "{\"id\":3,\"name\":\"Mock3\"}";
        JSONAssert.assertEquals(actual,expected,false);
    }

    @Test
    public void jsonAssert_WithoutEscape() throws JSONException {
        String actual  = "{id:3,name:Mock3}";
        JSONAssert.assertEquals(actual,expected,false);
    }
}
