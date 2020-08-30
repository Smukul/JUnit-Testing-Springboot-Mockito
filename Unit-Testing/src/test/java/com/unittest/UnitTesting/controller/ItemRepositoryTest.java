package com.unittest.UnitTesting.controller;

import com.unittest.UnitTesting.model.Item;
import com.unittest.UnitTesting.repository.ItemRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository repository;
    @Test
    public void findAllTest(){
        List<Item> items = repository.findAll();
        Assertions.assertEquals(3,items.size());
    }
    @Test
    public void findByIdTest(){
        Optional<Item> items = repository.findById(1001);

        Assertions.assertEquals(1001,items.get().id);
    }
}
