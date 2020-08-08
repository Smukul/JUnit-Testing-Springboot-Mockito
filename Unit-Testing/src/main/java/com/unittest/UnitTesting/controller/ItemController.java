package com.unittest.UnitTesting.controller;

import com.unittest.UnitTesting.business.ItemBusinessService;
import com.unittest.UnitTesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService businessService;

    @GetMapping("/item")
    public Item hello(){
        return new Item(1,"dummy-name",50,10);
    }

    @GetMapping("/item-business")
    public Item itemFromBusinessLayer(){
        return businessService.retrieveHardCodedItem();
    }
}
