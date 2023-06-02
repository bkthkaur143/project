package com.tns.cg.smms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.cg.smms.entities.OrderDetails;
import com.tns.cg.smms.service.OrderDetailsService;

@RestController
public class OrderDetailsController {
	@Autowired
	OrderDetailsService oService;

//Retrieve operation (retrieving all orders)
	@GetMapping("/Orders") // used to retrieve resource from server.
	public List<OrderDetails> list() {
		return oService.getAllOrders();
	}

	// Retrieve Operation (retrieving order by id)
	@GetMapping("/Orders/{id}")
	public ResponseEntity<OrderDetails> get(@PathVariable Integer id) {
		try {
			OrderDetails c1 = oService.getOrderById(id);
			return new ResponseEntity<OrderDetails>(c1, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
		}

	}

	// Create Operation
	@PostMapping("/Orders") // annotation ensures that HTTP POST requests to /Orders are mapped to add()
							// method.
	public void add(@RequestBody OrderDetails orders) {
		oService.save(orders);
	}

	// Update Operation
	@PutMapping("/Orders/{id}") // It maps the HTTP PUT requests
	public ResponseEntity<?> update(@RequestBody OrderDetails emp, @PathVariable Integer id) {
		/*
		 * @RequestBody: it is used to bind HTTP request with an object in a method
		 * parameter
		 * 
		 * @PathVariable: it is used to extract the values from the uri.
		 */

		try {
			OrderDetails exist = oService.getOrderById(id);
			oService.save(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete Operation // It Maps the HTTP DELETE requests
	@DeleteMapping("/Orders/{id}")
	public void delete(@PathVariable Integer id) {
		oService.delete(id);
	}
}
