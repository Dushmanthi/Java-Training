package com.spring.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.training.salesmanager.model.Employee;

@Repository("employeeRepository")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {
		
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		
		Employee employee =new Employee();
		employee.setEmployeeName("Dushi");
		employee.setEmployeeLocation("Gampaha");
		employees.add(employee);
		return employees;
		
		
	}
	
	
}
