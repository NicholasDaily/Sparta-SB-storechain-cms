package com.nicholasdaily.workcms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name="email")
    private String email;

    @Column(name="password")
    @JsonIgnore
    private String Password;

    @Column(name="enabled")
    private boolean enabled;

    @OneToOne(mappedBy = "employee",
              fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JsonManagedReference
    private EmployeeDetails details;

    @OneToOne(mappedBy = "employee", cascade = {CascadeType.ALL})
    ApiKey apiKey;

    public Employee() {
    }

    public Employee(String email, String password, boolean enabled) {
        this.email = email;
        Password = password;
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public EmployeeDetails getDetails() {
        return details;
    }

    public void setDetails(EmployeeDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", enabled=" + enabled +
                ", details=" + details +
                '}';
    }
}
