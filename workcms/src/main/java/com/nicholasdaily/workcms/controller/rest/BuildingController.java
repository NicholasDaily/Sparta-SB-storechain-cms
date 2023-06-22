package com.nicholasdaily.workcms.controller.rest;

import com.nicholasdaily.workcms.dao.BuildingDao;
import com.nicholasdaily.workcms.entity.Building;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    BuildingDao dao;

    BuildingController(BuildingDao dao){
        this.dao = dao;
    }

    @GetMapping
    public Building getAllBuildings(){
        Building building = dao.getBuildingWithAllEmployees(1);
        System.out.println(building);
        return building;
    }

}
