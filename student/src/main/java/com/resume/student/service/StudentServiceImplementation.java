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
        List<Student> student=studentRepository.findAll();
        if(student.isEmpty()){
            throw new RuntimeException("No Students Found");
        }
        return student;
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            return "Student Not found with id:" + id;
        }
        studentRepository.deleteById(id);
        return "Student deleted with id:" + id;
    }
}