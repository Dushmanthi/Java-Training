package com.spring.training.salesmanager.repository;

import java.util.List;

import com.spring.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();

}