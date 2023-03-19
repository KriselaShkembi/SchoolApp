package com.app.krisela.schoolapp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Subject's name is required!")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Student> students;

    public Subject() {
    }

    public Subject(Integer id, String name, Teacher teacher, List<Student> students) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.students = students;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
