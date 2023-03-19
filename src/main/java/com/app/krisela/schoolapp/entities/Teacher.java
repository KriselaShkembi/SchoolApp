package com.app.krisela.schoolapp.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Teacher's name is required!")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;

    @NotNull(message = "Salary is required!")
    @Min(value = 0, message = "Negative values are not allowed." )
    private Double salary;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="school_id")
    private School school;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Double salary, School school, Subject subject) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.school = school;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
