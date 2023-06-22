package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Building;

import java.util.List;

public interface BuildingDao {
    //create read update delete

    Building getBuildingById(int id);

    Building getBuildingWithAllEmployees(int id);

    List<Building> getAllBuildings();

    void createBuilding(Building building);

    Building updateBuilding(Building building);

    void deleteBuilding(Building building);

    void deleteBuildingById(int id);
}
