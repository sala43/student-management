package com.resume.student.service;

import com.resume.student.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(long id);
}
