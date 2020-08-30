package com.unittest.UnitTesting.controller;

import com.unittest.UnitTesting.business.ItemBusinessService;
import com.unittest.UnitTesting.model.Item;
import com.unittest.UnitTesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService businessService;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/item")
    public Item hello(){
        return new Item(1,"dummy-name",50,10);
    }

    @GetMapping("/item-business")
    public Item itemFromBusinessLayer(){
        return businessService.retrieveHardCodedItem();
    }

    @GetMapping("/all-item-db")
    public List<Item> getAllItemFromDatabase(){
        return businessService.findAll();
    }

    @PostMapping("/items")
    public ResponseEntity<Object> createItem(@Validated @RequestBody Item item){
        Item newItem = itemRepository.save(item);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newItem.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
