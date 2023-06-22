package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    EntityManager manager;

    EmployeeDaoImpl(EntityManager manager){
        this.manager=manager;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return manager.find(Employee.class, email);
    }

    public List<Employee> getEmployees(){
        TypedQuery<Employee> query = manager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return manager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeByEmail(String email) {
        Employee tempEmployee = manager.find(Employee.class, email);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        deleteEmployeeByEmail(employee.getEmail());
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        manager.persist(employee);
    }
}
