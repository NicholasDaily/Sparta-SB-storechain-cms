package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.BuildingStats;

import java.util.List;

public interface BuildingStatsDao {
    BuildingStats getBuildingStatsById(int id);

    List<BuildingStats> getAllBuildingStats();

    void createBuildingStats(BuildingStats buildingStats);

    BuildingStats updateBuildingStats(BuildingStats buildingStats);

    void deleteBuildingStats(BuildingStats buildingStats);

    void deleteBuildingStatsById(int id);
}
