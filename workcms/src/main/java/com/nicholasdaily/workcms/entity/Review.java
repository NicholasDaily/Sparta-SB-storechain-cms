package com.nicholasdaily.workcms.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee_reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @OneToOne
    @JoinColumn(name="employee_details_id")
    EmployeeDetails employeeDetails;

    @OneToOne
    @JoinColumn(name="reviewer_details_id")
    EmployeeDetails reviewerDetails;

    @Column(name="score")
    int score;

    @Column(name="notes")
    String notes;

    public Review() {
    }

    public Review(int score, String notes) {
        this.score = score;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public EmployeeDetails getReviewerDetails() {
        return reviewerDetails;
    }

    public void setReviewerDetails(EmployeeDetails reviewerDetails) {
        this.reviewerDetails = reviewerDetails;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", employeeDetails=" + employeeDetails +
                ", reviewerDetails=" + reviewerDetails +
                ", score=" + score +
                ", notes='" + notes + '\'' +
                '}';
    }
}
