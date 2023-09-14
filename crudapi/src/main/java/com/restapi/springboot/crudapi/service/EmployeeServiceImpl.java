package com.restapi.springboot.crudapi.service;


import com.restapi.springboot.crudapi.Entity.Employee;
import com.restapi.springboot.crudapi.dao.EmployeeDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao=theEmployeeDao;
    }

    @Override
    public List<Employee> findAll(){
        return employeeDao.findAll();
        }

    @Override
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee theEmployee) {
        return employeeDao.saveEmployee(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);

    }


}
