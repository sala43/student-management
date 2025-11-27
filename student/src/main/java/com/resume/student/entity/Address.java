package com.resume.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Place cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Place must contain only letters")
    private String place;
    @NotBlank(message = "District cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "District must contain only letters")
    private String district;
    @NotBlank(message = "State cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "State must contain only letters")
    private String state;
    @NotBlank(message = "Country cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Country must contain only letters")
    private String country;
    private long pincode;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Student student;

    public Address() {
    }

    public Address(long id, String place, String district, String state, String country, long pincode, Student student) {
        this.id = id;
        this.place = place;
        this.district = district;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
