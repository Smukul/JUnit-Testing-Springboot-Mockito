package com.unittest.UnitTesting.controller;

import com.unittest.UnitTesting.business.ItemBusinessService;
import com.unittest.UnitTesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ItemController.class)
@AutoConfigureMockMvc
public class ItemBusinessServiceTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemBusinessService businessService;

    @Test
    public void retrieveAllItemTest() throws Exception {
        when(businessService.findAll()).thenReturn(
                Arrays.asList(new Item(1,"TestItem1",2,4),
                new Item(3,"TestItem3",3,6),
                new Item(2,"TestItem2",4,8))
        );
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-item-db")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }
}
