package com.restapi.springboot.crudapi.dao;

import com.restapi.springboot.crudapi.Entity.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;



public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int theId );

    Employee saveEmployee(Employee theEmployee);

    void deleteById(int theId);




}
