package com.nicholasdaily.workcms.entity;

import jakarta.persistence.*;


@Entity
@Table(name="employee_details")
public class EmployeeDetails {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="employee_email")
    private Employee employee;

    @OneToOne
    @JoinColumn(name="building_id")
    Building building;

    @OneToOne
    @JoinColumn(name="position_id")
    Position position;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="salary")
    int salary;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


    public EmployeeDetails() {
    }

    public EmployeeDetails(int salary, String firstName, String lastName) {
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "employee=" + employee +
                ", building=" + building +
                ", id=" + id +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}