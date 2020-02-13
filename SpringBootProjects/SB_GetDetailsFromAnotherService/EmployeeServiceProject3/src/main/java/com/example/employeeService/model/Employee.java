package com.example.employeeService.model;

import java.beans.Transient;
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

import com.example.employeeService.sharedModel.Allocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String age;
	
	//OneToOne
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.EAGER)
	@JsonIgnore
	Address address;

	//OneToMany
	@OneToMany(mappedBy = "employee",cascade =CascadeType.ALL) //targetEntity =Telephone.class,
	List<Telephone> telephone;
	
	//ManyToManys
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "employee")

	@Fetch(value = FetchMode.SUBSELECT)
	List<Projects> projects;
	
	
	//Allocation
	//@Transient
	Allocation[] allocation;
	
	public Allocation[] getAllocation() {
		return allocation;
	}
	public void setAllocation(Allocation[] allocation) {
		this.allocation = allocation;
	}
	
	
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