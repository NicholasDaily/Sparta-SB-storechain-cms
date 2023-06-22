package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.BuildingStats;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingStatsDaoImpl implements BuildingStatsDao{
    EntityManager manager;

    BuildingStatsDaoImpl(EntityManager manager) {
        this.manager = manager;
    }
    @Override
    public BuildingStats getBuildingStatsById(int id) {
        return manager.find(BuildingStats.class, id);
    }

    @Override
    public List<BuildingStats> getAllBuildingStats() {
        TypedQuery<BuildingStats> query = manager.createQuery("FROM BuildingStats",BuildingStats.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createBuildingStats(BuildingStats buildingStats) {
        manager.persist(buildingStats);
    }

    @Override
    @Transactional
    public BuildingStats updateBuildingStats(BuildingStats buildingStats) {
        return manager.merge(buildingStats);
    }

    @Override
    @Transactional
    public void deleteBuildingStats(BuildingStats buildingStats) {
        deleteBuildingStatsById(buildingStats.getId());
    }

    @Override
    @Transactional
    public void deleteBuildingStatsById(int id) {
        BuildingStats buildingStats = manager.find(BuildingStats.class, id);
        manager.remove(buildingStats);
    }
}
