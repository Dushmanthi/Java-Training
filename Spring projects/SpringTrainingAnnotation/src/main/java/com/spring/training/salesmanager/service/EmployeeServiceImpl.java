package com.spring.training.salesmanager.service;

import java.util.List;

import com.spring.training.salesmanager.model.Employee;
import com.spring.training.salesmanager.repository.EmployeeRepository;
import com.spring.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	//private EmployeeRepository employeeRepository ;
	 EmployeeRepository employeeRepository ;
	 
	 public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		 this.employeeRepository =employeeRepository;
	 }

	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
}
