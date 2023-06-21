package com.nicholasdaily.workcms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="building_stats")
public class BuildingStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="expenses")
    private int expenses;

    @Column(name="income")
    private int income;

    @OneToOne
    @JoinColumn(name = "building_id")
    Building building;

    @Column(name="employee_quantity")
    private int employeeQuantity;

    public BuildingStats() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(int employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    @Override
    public String toString() {
        return "BuildingStats{" +
                "id=" + id +
                ", expenses=" + expenses +
                ", income=" + income +
                ", employeeQuantity=" + employeeQuantity +
                '}';
    }
}
