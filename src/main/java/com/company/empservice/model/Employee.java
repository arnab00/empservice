package com.company.empservice.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@NotNull(message = "Employee ID is mandatory")
	private String employeeId;

	@NotNull(message = "First Name is mandatory")
	private String firstName;

	@NotNull(message = "Last Name is mandatory")
	private String lastName;

	@Email(message = "Email should be valid")
	@NotNull(message = "Email is mandatory")
	private String email;

	@NotNull(message = "Phone Number is mandatory")
	@ElementCollection
	private List<String> phoneNumbers;

	@NotNull(message = "Date of Joining is mandatory")
	private LocalDate dateOfJoining;

	@Min(value = 0, message = "Salary must be positive")
	@NotNull(message = "Salary is mandatory")
	private Double salary;

}