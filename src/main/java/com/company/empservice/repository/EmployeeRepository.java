package com.company.empservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.empservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}