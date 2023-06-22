package com.nicholasdaily.workcms.controller.rest;

import com.nicholasdaily.workcms.dao.BuildingDao;
import com.nicholasdaily.workcms.dao.ProductDao;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/products")
public class ProductController {
    ProductDao dao;

    ProductController(ProductDao dao){
        this.dao = dao;
    }

}
