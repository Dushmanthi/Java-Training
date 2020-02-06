package com.spring.training.salesmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.spring.training.salesmanager.repository.EmployeeRepository;
import com.spring.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.spring.training.salesmanager.service.EmployeeService;
import com.spring.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
@ComponentScan("com.spring")
@PropertySource("application.properties")
public class ApplicationConfiguration {
	@Bean(name = "employeeService")
	//@Scope("singleton")
	@Scope("prototype")
	public EmployeeService getEmployeeService() {
		
		//EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		//employeeService.setEmployeeRepository(getEmployeeRepository());
		
		//EmployeeServiceImpl employeeService = new EmployeeServiceImpl(getEmployeeRepository());
		
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		return employeeService;
		
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
/*	@Bean(name ="employeeRepository")
		public EmployeeRepository getEmployeeRepository() {
			return new HibernateEmployeeRepositoryImpl();
		}
*/		
	}

