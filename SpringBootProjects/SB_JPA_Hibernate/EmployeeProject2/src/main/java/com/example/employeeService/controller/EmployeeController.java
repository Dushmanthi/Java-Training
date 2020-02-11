package com.example.employeeService.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeService.model.Employee;
import com.example.employeeService.service.EmployeeService;

@RestController
@RequestMapping("/service")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
//	@RequestMapping("/save")
//	public Employee employeeDetails() {
//		//employee details
//		Employee employee = new Employee();
//		employee.setName("Dushi");
//		employee.setCity("Gampaha");
//		
		//address details
//		Address address = new Address();
//		address.
//		employee.setAddress(address);
//		return employee;
//}
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public Employee save(@RequestBody Employee employee) {
	        return employeeService.createEmployee(employee);
	    }

	    @RequestMapping(value = "/findAllEmployees", method = RequestMethod.GET)
	    public List<Employee> findAll() {
	        return employeeService.findEmployee();
	    }

	    @RequestMapping("/findById/{id}")
	    public Integer findById(@PathVariable("id") Integer id) {
	        return employeeService.findById(id).getId();
	    }

	

}
