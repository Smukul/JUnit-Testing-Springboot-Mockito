package com.unittest.UnitTesting.business;

import com.unittest.UnitTesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retrieveHardCodedItem(){
        return new Item(2,"Mobile-Phone",15000,15);
    }
}
