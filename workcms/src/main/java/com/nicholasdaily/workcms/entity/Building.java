package com.nicholasdaily.workcms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy="building", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonBackReference
    List<EmployeeDetails> employeeDetails;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "type_id")
    BuildingType buildingType;

    @OneToOne(mappedBy = "building", cascade = CascadeType.ALL)
    BuildingStats buildingStats;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    List<BuildingToProduct> products;

    public Building() {
    }

    public Building(String address, String phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public List<EmployeeDetails> getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(List<EmployeeDetails> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public BuildingStats getBuildingStats() {
        return buildingStats;
    }

    public void setBuildingStats(BuildingStats buildingStats) {
        this.buildingStats = buildingStats;
    }

    public List<BuildingToProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BuildingToProduct> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", buildingType=" + buildingType +
                '}';
    }
}
