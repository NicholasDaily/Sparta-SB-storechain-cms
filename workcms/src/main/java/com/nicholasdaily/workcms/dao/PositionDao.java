package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Position;

import java.util.List;

public interface PositionDao {
    Position getPositionById(int id);

    List<Position> getAllPositions();

    void createPosition(Position Position);

    Position updatePosition(Position Position);

    void deletePosition(Position Position);

    void deletePositionById(int id);
}
