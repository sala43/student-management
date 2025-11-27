package com.resume.student.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
    private String firstName;

    @NotBlank(message = "Second name cannot be empty")
    @Size(min = 2, max = 20, message = "Second name must be between 2 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Second name must contain only letters")
    private String secondName;

    @Min(value = 1, message = "Age must be above 0")
    @Max(value = 120, message = "Age cannot be more than 120")
    private int age;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Role cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Role must contain only letters")
    private String role;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 5, message = "Password must be at least 5 characters")
    private String password;

    // --- One-to-One: Student has one Address ---
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @Valid
    private Address address;

    // --- One-to-Many: Student has many Educations ---
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private List<Education> educationList;

    // --- One-to-Many: Student has many Certificates ---
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Valid
    private List<Certificate> certificates;

    public Student() {
    }

    public Student(long id, String firstName, String secondName, int age, String email, String role, String password, Address address, List<Education> educationList, List<Certificate> certificates) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.role = role;
        this.password = password;
        this.address = address;
        this.educationList = educationList;
        this.certificates = certificates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}
