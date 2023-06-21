package com.nicholasdaily.workcms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BuildingToProductKey implements Serializable {
    @Column(name="building_id")
    int buildingId;

    @Column(name="product_id")
    int productId;
}
