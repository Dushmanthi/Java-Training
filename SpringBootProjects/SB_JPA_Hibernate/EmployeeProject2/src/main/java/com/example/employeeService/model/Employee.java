package com.example.employeeService.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String city;
	
	//OneToOne
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee")
	Address address;
	
	//OneToMany
	@OneToMany(mappedBy = "employee")
	List<Telephone> telephone;
	
	
	@ManyToMany(mappedBy = "employee",fetch = FetchType.LAZY)
	Set<Projects> projects = new HashSet<Projects>();
	
	
	public Set<Projects> getProjects() {
		return projects;
	}
	public void setProjects(Set<Projects> projects) {
		this.projects = projects;
	}
	
	
	
	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	public Employee(Integer id, String name, String city) {
//		
//		this.id = id;
//		this.name = name;
//		this.city = city;
//	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

//	public static List<Employee> getAllEmployees() {
//		List<Employee> employeeList = new ArrayList<Employee>();
//
//		employeeList.add(new Employee("Jonny", 90));
//		employeeList.add(new Employee("Mike", 85));
//		employeeList.add(new Employee("Leena", 92));
//		employeeList.add(new Employee("Alice", 55));
//		employeeList.add(new Employee("Bob", 77));
//		return employeeList;
//	}

}