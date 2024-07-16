package com.company.empservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaxResponse {
	private String employeeId;
	private String firstName;
	private String lastName;
	private Double yearlySalary;
	private Double taxAmount;
	private Double cessAmount;
}
