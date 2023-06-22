package com.nicholasdaily.workcms.controller.rest;

import com.nicholasdaily.workcms.dao.BuildingDao;
import com.nicholasdaily.workcms.dao.EmployeeDao;
import com.nicholasdaily.workcms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    EmployeeDao dao;

    EmployeeController(EmployeeDao dao){
        this.dao = dao;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return dao.getEmployees();
    }

}
