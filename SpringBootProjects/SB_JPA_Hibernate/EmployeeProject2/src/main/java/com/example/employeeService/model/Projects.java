package com.example.employeeService.model;

import java.util.HashSet;
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

@Entity
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String projectName;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	
	@JoinTable(name = "emp_project", joinColumns = {
			@JoinColumn(name = "empId", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "proId", referencedColumnName = "id") })
	
	Set<Employee> employee = new HashSet<>();

	public Projects(Integer id, String projectName) {
		this.id = id;
		this.projectName = projectName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}
