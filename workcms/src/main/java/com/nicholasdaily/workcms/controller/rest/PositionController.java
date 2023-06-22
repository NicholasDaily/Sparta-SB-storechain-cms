package com.nicholasdaily.workcms.controller.rest;

import com.nicholasdaily.workcms.dao.BuildingDao;
import com.nicholasdaily.workcms.dao.PositionDao;
import com.nicholasdaily.workcms.entity.Position;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    PositionDao dao;

    PositionController(PositionDao dao){
        this.dao = dao;
    }

    @GetMapping("/{positionId}")
    public Position getPositionById(@PathVariable int positionId){
        return dao.getPositionById(positionId);
    }


}
