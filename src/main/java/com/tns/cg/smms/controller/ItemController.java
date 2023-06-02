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

import com.tns.cg.smms.entities.Item;
import com.tns.cg.smms.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	ItemService service;

//Retrieve operation (retrieving all itemss)
	@GetMapping("/Items") // used to retrieve resource from server.
	public List<Item> list() {
		return service.getAllItems();
	}

	// Retrieve Operation (retrieving item by id)
	@GetMapping("/Items/{id}")
	public ResponseEntity<Item> get(@PathVariable Integer id) {
		try {
			Item item = service.getItemById(id);
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

	}

	// Create Operation
	@PostMapping("/Items") // annotation ensures that HTTP POST requests to /Items are mapped to add()
							// method.
	public void add(@RequestBody Item item) {
		service.save(item);
	}

	// Update Operation
	@PutMapping("/Items/{id}") // It maps the HTTP PUT requests
	public ResponseEntity<?> update(@RequestBody Item emp, @PathVariable Integer id) {
		/*
		 * @RequestBody: it is used to bind HTTP request with an object in a method
		 * parameter
		 * 
		 * @PathVariable: it is used to extract the values from the uri.
		 */

		try {
			Item exist = service.getItemById(id);
			service.save(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete Operation // It Maps the HTTP DELETE requests
	@DeleteMapping("/Items/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
