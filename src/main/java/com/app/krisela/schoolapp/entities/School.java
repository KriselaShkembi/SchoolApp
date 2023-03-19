package com.app.krisela.schoolapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double moneyEarned;

    private Double moneySpent;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Student> students;

    public School() {
    }

    public School(Integer id, Double moneyEarned, Double moneySpent, List<Teacher> teachers, List<Student> students) {
        this.id = id;
        this.moneyEarned = moneyEarned;
        this.moneySpent = moneySpent;
        this.teachers = teachers;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(Double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public Double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(Double moneySpent) {
        this.moneySpent = moneySpent;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
