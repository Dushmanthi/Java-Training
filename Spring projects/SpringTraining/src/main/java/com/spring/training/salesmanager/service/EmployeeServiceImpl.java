package com.spring.training.salesmanager.service;

import java.util.List;

import com.spring.training.salesmanager.model.Employee;
import com.spring.training.salesmanager.repository.EmployeeRepository;
import com.spring.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();

	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}
}
