package com.restapi.springboot.crudapi.dao;

import com.restapi.springboot.crudapi.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class Impl implements EmployeeDao{

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public Impl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee= entityManager.find(Employee.class, theId);
        return theEmployee;

    }

    @Override
    public Employee saveEmployee(Employee theEmployee) {

        Employee dbEmployee= entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee dbEMployee = entityManager.find(Employee.class, theId);

        entityManager.remove(dbEMployee);


    }
}
