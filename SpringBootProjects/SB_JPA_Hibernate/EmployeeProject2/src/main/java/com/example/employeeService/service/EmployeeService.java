package com.example.employeeService.service;

import java.util.List;

import com.example.employeeService.model.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	
	public List<Employee> findEmployee();
	
	public Employee findById(int id);
}
