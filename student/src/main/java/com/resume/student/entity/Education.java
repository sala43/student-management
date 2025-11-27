package com.resume.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.resume.student.entity.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message="schoolName must be enter")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "School name must contain only letters and spaces")
    private String schoolName;
    @NotBlank(message="specialization must be enter")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "specialization must contain only letters and spaces")
    private String specialization;
    @NotBlank(message = "Purshing is required")
    @Size(max = 50, message = "Purshing cannot exceed 50 characters")
    private String purshing;

    @NotBlank(message = "Start year is required")
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "Start year must be a valid 4-digit year")
    private String startYear;

    @NotBlank(message = "End year is required")
    @Pattern(regexp = "^(19|20)\\d{2}$", message = "End year must be a valid 4-digit year")
    private String endYear;

    @NotNull(message = "isCompleted is required")
    private Boolean isCompleted;

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
