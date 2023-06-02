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

import com.tns.cg.smms.entities.Employee;
import com.tns.cg.smms.service.EmployeeService;

@RestController // identifies spring boot Rest controller
public class EmployeeController {
	@Autowired // This means to get the bean which is auto-generated by Spring
	EmployeeService employeeService;

	// Retrieve operation (retrieving all employees)
	@GetMapping("/Employees") // used to retrieve resource from server.
	public List<Employee> list() {
		return employeeService.getAllEmployees();
	}

	// Retrieve Operation (retrieving employee by id)
	@GetMapping("/Employees/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
		try {
			Employee emp = employeeService.getEmployeeById(id);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

	}

	// Create Operation
	@PostMapping("/Employees") // annotation ensures that HTTP POST requests to /Employees are mapped to add()
								// method.
	public void add(@RequestBody Employee emp1) {
		employeeService.save(emp1);
	}

	// Update Operation
	@PutMapping("/Employees/{id}") // It maps the HTTP PUT requests
	public ResponseEntity<?> update(@RequestBody Employee emp, @PathVariable Integer id) {
		/*
		 * @RequestBody: it is used to bind HTTP request with an object in a method
		 * parameter
		 * 
		 * @PathVariable: it is used to extract the values from the uri.
		 */

		try {
			Employee exist = employeeService.getEmployeeById(id);
			employeeService.save(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete Operation // It Maps the HTTP DELETE requests
	@DeleteMapping("/Employees/{id}")
	public void delete(@PathVariable Integer id) {
		employeeService.delete(id);
	}
}
