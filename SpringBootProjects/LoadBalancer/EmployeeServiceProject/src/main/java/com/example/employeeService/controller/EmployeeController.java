package com.example.employeeService.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import com.example.employeeService.model.Address;
import com.example.employeeService.model.Projects;
import com.example.employeeService.model.Telephone;
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

 //   @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public Employee test() {
//        Employee employee = new Employee();
//        employee.setName("Madu");
//        employee.setAge("25");
//
//        Address address=new Address();
//        address.setStreet("fxgf");
//        address.setCity("sffsgf");
//
//        List<Telephone> telephones1=new ArrayList<>();
//        Telephone t=new Telephone();
//        t.setNumber("1234567");
//        telephones1.add(t);
//        employee.setTelephone(telephones1);
//
//        List<Projects> projects=new ArrayList<>();
//        Projects projects1=new Projects();
//        projects1.setProjectName("p1");
//
//        Projects projects2=new Projects();
//        projects2.setProjectName("p2");
//        projects.add(projects1);
//        projects.add(projects2);
//        employee.setProjects(projects);
//        return employee;
//
//    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        employee.getTelephone().stream().forEach(telephone -> telephone.setEmployee(employee));

        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "/findAllEmployees", method = RequestMethod.GET)
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @RequestMapping("/findById/{id}")
    public Employee findById(@PathVariable("id") Integer id) {
        return employeeService.findByEmployeeId(id);
    }


}
