package com.spring.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.training.salesmanager.model.Employee;
import com.spring.training.salesmanager.repository.EmployeeRepository;
import com.spring.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	 EmployeeRepository employeeRepository ;
	 
	 public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		 System.out.println("overload constructor executed");
		 this.employeeRepository =employeeRepository;
	 }
	 
	 public EmployeeServiceImpl() {
		 System.out.println("default constructor executed");
	 }

	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("setter executed");
		this.employeeRepository = employeeRepository;
	}
	
	
}
