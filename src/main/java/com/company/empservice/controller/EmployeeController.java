package com.company.empservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.empservice.model.Employee;
import com.company.empservice.model.TaxResponse;
import com.company.empservice.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/tax")
	public ResponseEntity<List<TaxResponse>> getTaxDeduction() {
		List<TaxResponse> taxResponses = employeeService.calculateTax();
		return new ResponseEntity<>(taxResponses, HttpStatus.OK);
	}

}