package com.nicholasdaily.workcms.entity;

import jakarta.persistence.*;

@Entity
@Table(name="building_to_product")
public class BuildingToProduct {
    @EmbeddedId
    BuildingToProductKey key;

    @ManyToOne
    @MapsId("buildingId")
    @JoinColumn(name="building_id")
    Building building;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    Product product;

    @Column(name="quantity")
    int quantity;

    @Column(name="cost")
    float cost;

    @Column(name="value")
    float value;

    @Column(name="sales")
    int sales;

    public BuildingToProduct() {
    }

    public BuildingToProduct(int quantity, float cost, float value, int sales) {
        this.quantity = quantity;
        this.cost = cost;
        this.value = value;
        this.sales = sales;
    }

    public BuildingToProductKey getKey() {
        return key;
    }

    public void setKey(BuildingToProductKey key) {
        this.key = key;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "BuildingToProduct{" +
                ", building=" + building +
                ", product=" + product +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", value=" + value +
                ", sales=" + sales +
                '}';
    }
}
