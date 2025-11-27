package com.resume.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.resume.student.entity.Student;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String schoolName;
    private String specialization;
    private String purshing;
    private String startYear;
    private String endYear;
    private boolean isCompleted;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Education() {
    }

    public Education(long id, String schoolName, String specialization, String purshing, String startYear, String endYear, boolean isCompleted, Student student) {
        this.id = id;
        this.schoolName = schoolName;
        this.specialization = specialization;
        this.purshing = purshing;
        this.startYear = startYear;
        this.endYear = endYear;
        this.isCompleted = isCompleted;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPurshing() {
        return purshing;
    }

    public void setPurshing(String purshing) {
        this.purshing = purshing;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
