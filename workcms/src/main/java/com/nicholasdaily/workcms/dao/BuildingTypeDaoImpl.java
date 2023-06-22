package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.BuildingType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingTypeDaoImpl implements BuildingTypeDao {
    EntityManager manager;

    BuildingTypeDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public BuildingType getBuildingTypeById(int id) {
        return manager.find(BuildingType.class, id);
    }

    @Override
    public List<BuildingType> getAllBuildingType() {
        TypedQuery<BuildingType> query = manager.createQuery("FROM BuildingType", BuildingType.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createBuildingType(BuildingType BuildingType) {
        manager.persist(BuildingType);
    }

    @Override
    @Transactional
    public BuildingType updateBuildingType(BuildingType BuildingType) {
        return manager.merge(BuildingType);
    }

    @Override
    @Transactional
    public void deleteBuildingType(BuildingType BuildingType) {
        deleteBuildingTypeById(BuildingType.getId());
    }

    @Override
    @Transactional
    public void deleteBuildingTypeById(int id) {
        BuildingType tempBuildingType = manager.find(BuildingType.class, id);
        manager.remove(tempBuildingType);
    }
}