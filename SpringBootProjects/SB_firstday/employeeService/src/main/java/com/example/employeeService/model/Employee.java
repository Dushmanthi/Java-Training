package com.example.employeeService.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	String name;
	int marks;

	public Employee(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public static List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee("Jonny", 90));
		employeeList.add(new Employee("Mike", 85));
		employeeList.add(new Employee("Leena", 92));
		employeeList.add(new Employee("Alice", 55));
		employeeList.add(new Employee("Bob", 77));
		return employeeList;
	}

}