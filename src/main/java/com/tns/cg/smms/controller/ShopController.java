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

import com.tns.cg.smms.entities.Shop;
import com.tns.cg.smms.service.ShopService;

@RestController
public class ShopController {
@Autowired
ShopService service;

//Retrieve operation (retrieving all Shops)
	@GetMapping("/Shops") // used to retrieve resource from server.
	public List<Shop> list() {
		return service.getAllShops();
	}

	// Retrieve Operation (retrieving Shop by id)
	@GetMapping("/Shops/{id}")
	public ResponseEntity<Shop> get(@PathVariable Integer id) {
		try {
			Shop c1 = service.getShopById(id);
			return new ResponseEntity<Shop>(c1, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);
		}

	}

	// Create Operation
	@PostMapping("/Shops") // annotation ensures that HTTP POST requests to /Shops are mapped to add()
								// method.
	public void add(@RequestBody Shop shop) {
		service.save(shop);
	}

	// Update Operation
	@PutMapping("/Shops/{id}") // It maps the HTTP PUT requests
	public ResponseEntity<?> update(@RequestBody Shop emp, @PathVariable Integer id) {
		/*
		 * @RequestBody: it is used to bind HTTP request with an object in a method
		 * parameter
		 * 
		 * @PathVariable: it is used to extract the values from the uri.
		 */

		try {
			Shop exist = service.getShopById(id);
			service.save(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete Operation // It Maps the HTTP DELETE requests
	@DeleteMapping("/Shops/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
