package com.unittest.UnitTesting.business;

import com.unittest.UnitTesting.model.Item;
import com.unittest.UnitTesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardCodedItem(){
        return new Item(2,"Mobile-Phone",15000,15);
    }

    public List<Item> findAll(){
        List<Item> items = repository.findAll();
        for(Item item : items){
            item.setValue(item.price*item.quantity);
        }
        return items;
    }
}
