package com.example.employeeService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeService.model.Employee;
import com.example.employeeService.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> findEmployee() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();
	}

}
