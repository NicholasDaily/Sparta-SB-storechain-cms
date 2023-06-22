package com.nicholasdaily.workcms.controller.rest;

import com.nicholasdaily.workcms.dao.BuildingDao;
import com.nicholasdaily.workcms.dao.BuildingDaoImpl;
import com.nicholasdaily.workcms.dao.EmployeeDao;
import com.nicholasdaily.workcms.dao.EmployeeDetailsDao;
import com.nicholasdaily.workcms.entity.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeDetails")
public class EmployeeDetailsController {
    EmployeeDetailsDao dao;
    BuildingDao buildingDao;

    EmployeeDetailsController(EmployeeDetailsDao dao, BuildingDao buildingDao){
        this.dao = dao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<EmployeeDetails> getEmployeeDetails(){
        return dao.getAllEmployeeDetails();
    }
    
    @GetMapping("/buildings/{buildingNumber}")
    public List<EmployeeDetails> getEmployeesFromBuildingNumber(@PathVariable int buildingNumber){

        return buildingDao.getBuildingWithAllEmployees(buildingNumber).getEmployeeDetails();
    }

}
