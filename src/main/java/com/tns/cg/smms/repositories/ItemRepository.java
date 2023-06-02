package com.tns.cg.smms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.cg.smms.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
