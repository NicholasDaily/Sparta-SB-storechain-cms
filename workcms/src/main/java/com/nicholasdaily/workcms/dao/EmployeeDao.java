package com.nicholasdaily.workcms.dao;


import com.nicholasdaily.workcms.entity.Employee;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployeeByEmail(String email);

    List<Employee> getEmployees();

    Employee updateEmployee(Employee employee);

    void deleteEmployeeByEmail(String email);

    void deleteEmployee(Employee employee);

    void createEmployee(Employee employee);
}
