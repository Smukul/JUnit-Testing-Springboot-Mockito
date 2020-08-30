package com.unittest.UnitTesting.integration;

import com.unittest.UnitTesting.controller.ItemController;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

//@WebMvcTest(controllers = ItemController.class)
//@AutoConfigureMockMvc
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void contextLoadTest() throws JSONException {
        String response = this.testRestTemplate.getForObject("/all-item-db",String.class);
        System.out.println(response);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]",response,false);
    }
}
