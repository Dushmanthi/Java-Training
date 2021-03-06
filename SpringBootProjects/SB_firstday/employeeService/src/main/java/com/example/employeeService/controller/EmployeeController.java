package com.example.employeeService.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeService.model.Employee;

@RestController
@RequestMapping("/service")
public class EmployeeController {
	
	@RequestMapping("/hello")
	public String greeting() {
		return "<h1>Hello Employees!!!</h1>";
	}
	
	@RequestMapping("/employee")
	public List<Employee> getEmployees() {
		return Employee.getAllEmployees();
	}
	

}
