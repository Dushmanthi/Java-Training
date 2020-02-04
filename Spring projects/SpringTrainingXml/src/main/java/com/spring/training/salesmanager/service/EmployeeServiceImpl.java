package com.spring.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.salesmanager.model.Employee;
import com.spring.training.salesmanager.repository.EmployeeRepository;
import com.spring.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	 @Autowired
	 EmployeeRepository employeeRepository ;
	 
	 public EmployeeServiceImpl() {
		 System.out.println("Default constructor executed ");
	 }
	 
	 public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		 System.out.println("Overloaded constructor executed ");
		 this.employeeRepository =employeeRepository;
	 }

	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
	
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter injection fired ");
		this.employeeRepository = employeeRepository;
	}
	
	
}
