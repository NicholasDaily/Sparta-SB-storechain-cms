package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.BuildingType;

import java.util.List;

public interface BuildingTypeDao {
    BuildingType getBuildingTypeById(int id);

    List<BuildingType> getAllBuildingType();

    void createBuildingType(BuildingType BuildingType);

    BuildingType updateBuildingType(BuildingType BuildingType);

    void deleteBuildingType(BuildingType BuildingType);

    void deleteBuildingTypeById(int id);
}
