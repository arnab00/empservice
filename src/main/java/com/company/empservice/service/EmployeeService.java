package com.company.empservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.empservice.model.Employee;
import com.company.empservice.model.TaxResponse;
import com.company.empservice.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<TaxResponse> calculateTax() {

		return employeeRepository.findAll().stream().map(e -> {
			Double ys = calculateYearlySalary(e);
			return new TaxResponse(e.getEmployeeId(), e.getFirstName(), e.getLastName(), ys, calculateTax(ys),
					calculateCess(ys));
		}).collect(Collectors.toList());

	}

	private Double calculateYearlySalary(Employee employee) {
		LocalDate joinDate = employee.getDateOfJoining();
		Double monthlySalary = employee.getSalary();
		Integer monthsWorked = 12 - (joinDate.getMonthValue() - 1); // Simplistic calculation
		return monthlySalary * monthsWorked;
	}

	private Double calculateTax(double yearlySalary) {
		if (yearlySalary <= 250000)
			return 0D;
		if (yearlySalary <= 500000)
			return (yearlySalary - 250000) * 0.05;
		if (yearlySalary <= 1000000)
			return (250000 * 0.05) + (yearlySalary - 500000) * 0.10;
		return (250000 * 0.05) + (500000 * 0.10) + (yearlySalary - 1000000) * 0.20;
	}

	private Double calculateCess(double yearlySalary) {
		if (yearlySalary > 2500000) {
			return (yearlySalary - 2500000) * 0.02;
		}
		return 0D;
	}
}
