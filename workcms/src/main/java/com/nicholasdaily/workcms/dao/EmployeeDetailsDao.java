package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.EmployeeDetails;

import java.util.List;

public interface EmployeeDetailsDao {
    EmployeeDetails getEmployeeDetailsById(int id);

    List<EmployeeDetails> getAllEmployeeDetails();

    EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails);

    void deleteEmployeeDetails(EmployeeDetails employeeDetails);

    void deleteEmployeeDetailsById(int id);

    void createEmployeeDetails(EmployeeDetails employeeDetails);
}
