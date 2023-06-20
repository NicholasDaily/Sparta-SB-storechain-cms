package com.nicholasdaily.workcms.entity;

import jakarta.persistence.*;

@Entity
@Table(name="api_keys")
public class ApiKey {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employee_email")
    private Employee employee;

    @Column(name = "key")
    private String key;

    public ApiKey() {
    }

    public ApiKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ApiKey{" +
                "id=" + id +
                ", employee=" + employee +
                ", key='" + key + '\'' +
                '}';
    }
}
