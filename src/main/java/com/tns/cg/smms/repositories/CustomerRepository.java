package com.tns.cg.smms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.cg.smms.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
