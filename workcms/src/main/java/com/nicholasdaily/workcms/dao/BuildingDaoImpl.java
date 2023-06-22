package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Building;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingDaoImpl implements BuildingDao{
    EntityManager manager;

    BuildingDaoImpl(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public Building getBuildingById(int id) {
        return manager.find(Building.class, id);
    }

    @Override
    public Building getBuildingWithAllEmployees(int id) {
        TypedQuery<Building> query = manager.createQuery("SELECT b FROM Building b JOIN FETCH b.employeeDetails WHERE b.id =:data", Building.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public List<Building> getAllBuildings() {
        TypedQuery<Building> query = manager.createQuery("FROM Building", Building.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createBuilding(Building building) {
        manager.persist(building);
    }

    @Override
    @Transactional
    public Building updateBuilding(Building building) {
        return manager.merge(building);
    }

    @Override
    @Transactional
    public void deleteBuilding(Building building) {
        deleteBuildingById(building.getId());
    }

    @Override
    @Transactional
    public void deleteBuildingById(int id) {
        Building tempBuilding = manager.find(Building.class, id);
        manager.remove(tempBuilding);
    }
}
