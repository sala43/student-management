package com.resume.student.service;

import com.resume.student.entity.Certificate;
import com.resume.student.entity.Education;
import com.resume.student.entity.Student;
import com.resume.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImplementation implements StudentService{
    @Autowired
     StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {

        // Set bidirectional relations for education list
        if (student.getEducationList() != null) {
            for (Education e : student.getEducationList()) {
                e.setStudent(student);
            }
        }

        // Set bidirectional for certificates
        if (student.getCertificates() != null) {
            for (Certificate c : student.getCertificates()) {
                c.setStudent(student);
            }
        }

        // Address (one-to-one)
        if (student.getAddress() != null) {
            student.getAddress().setStudent(student);
        }

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }
}