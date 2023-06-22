package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao{
    EntityManager manager;

    PositionDaoImpl(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public Position getPositionById(int id) {
        return manager.find(Position.class, id);
    }

    @Override
    public List<Position> getAllPositions() {
        TypedQuery<Position> query = manager.createQuery("FROM Position", Position.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createPosition(Position Position) {
        manager.persist(Position);
    }

    @Override
    @Transactional
    public Position updatePosition(Position Position) {
        return manager.merge(Position);
    }

    @Override
    @Transactional
    public void deletePosition(Position Position) {
        deletePositionById(Position.getId());
    }

    @Override
    @Transactional
    public void deletePositionById(int id) {
        Position tempPosition = manager.find(Position.class, id);
        manager.remove(tempPosition);
    }
}
