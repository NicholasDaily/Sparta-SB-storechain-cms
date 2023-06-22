package com.nicholasdaily.workcms.controller.rest;

import com.nicholasdaily.workcms.dao.BuildingDao;
import com.nicholasdaily.workcms.dao.BuildingTypeDao;
import com.nicholasdaily.workcms.entity.BuildingType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildingTypes")
public class BuildingTypeController {
    BuildingTypeDao dao;

    BuildingTypeController(BuildingTypeDao dao){
        this.dao = dao;
    }

    @GetMapping
    public List<BuildingType> getAllBuildingTypes(){
        return dao.getAllBuildingType();
    }
}
