package com.example.RestApiExample.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApiExample.Repo.EmployeeRepo;
import com.example.RestApiExample.modal.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo emp;

	@Autowired
	private Environment env;

	// Getting properties values from properties file.
	// http://localhost:9999/hello/
	@GetMapping("/hello")
	public String getPropertiesValues() {
		return env.getProperty("spring.datasource.url");
	}
	
	@GetMapping("/statuscode")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	// http://localhost:9999/h2-console/
	// http://localhost:9999/employee/1
	// Employee id available in db, will get object and status code is 200 ok.
	// Employee id not available then will got 404 not found tatus code.
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getInfo(@PathVariable Long id) {
		try {
			Employee eInfo = emp.findById(id).get();
			return new ResponseEntity<Employee>(eInfo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

}
