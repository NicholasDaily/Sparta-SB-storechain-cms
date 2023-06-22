package com.nicholasdaily.workcms.controller.rest;

import com.nicholasdaily.workcms.dao.BuildingDao;
import com.nicholasdaily.workcms.dao.ReviewDao;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/reviews")
public class ReviewController {
    ReviewDao dao;

    ReviewController(ReviewDao dao){
        this.dao = dao;
    }


}
