package com.unittest.UnitTesting.repository;

import com.unittest.UnitTesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
