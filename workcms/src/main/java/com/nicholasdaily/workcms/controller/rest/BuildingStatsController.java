package com.nicholasdaily.workcms.controller.rest;

import com.nicholasdaily.workcms.dao.BuildingDao;
import com.nicholasdaily.workcms.dao.BuildingStatsDao;
import com.nicholasdaily.workcms.entity.Building;
import com.nicholasdaily.workcms.entity.BuildingStats;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildingStats")
public class BuildingStatsController {
    BuildingStatsDao dao;

    BuildingStatsController(BuildingStatsDao dao){
        this.dao = dao;
    }

    @GetMapping
    public List<BuildingStats> getAllBuildingStats(){
        return dao.getAllBuildingStats();
    }
}
