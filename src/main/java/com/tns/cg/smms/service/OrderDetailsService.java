package com.tns.cg.smms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.cg.smms.entities.OrderDetails;
import com.tns.cg.smms.repositories.OrderDetailsRepository;

@Service
@Transactional
public class OrderDetailsService {
	@Autowired
	// This means to get the bean which is auto-generated by Spring
	// We will use it to handle the data
	OrderDetailsRepository oRepository;
	
	// Retreiving all orders
	public List<OrderDetails> getAllOrders(){
		return oRepository.findAll();
	}
	
	// Creating New orders
	public void save(OrderDetails emp) {
		oRepository.save(emp);
	}
	
	//  Retreiving order by id
	public OrderDetails getOrderById(Integer id) {
		return oRepository.findById(id).get();
	}
	
	// Deleting order from database
	public void delete(Integer id) {
		oRepository.deleteById(id);
	}
}
