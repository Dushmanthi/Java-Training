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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String age;
	
	//OneToOne
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.EAGER)
	Address address;
	
	//OneToMany
	@OneToMany(mappedBy = "employee")
	List<Telephone> telephone;
	
	//ManyToManys
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinTable(name = "employee_project",
				joinColumns = {@JoinColumn(name = "empId", referencedColumnName = "id") },
				inverseJoinColumns = {@JoinColumn(name = "proId", referencedColumnName = "id") })
	
	@Fetch(value = FetchMode.SUBSELECT)
	List<Projects> projects;
	
	//project
	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	//telephone
	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}
	//address
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//employee
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	

}