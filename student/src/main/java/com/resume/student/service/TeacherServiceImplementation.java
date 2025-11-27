package com.resume.student.service;

import com.resume.student.entity.Teacher;
import com.resume.student.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImplementation implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Teacher createTeacher(Teacher tech) {
        return teacherRepository.save(tech);
    }

    @Override
    public Teacher getTeacherById(long id) {
        return null;
    }

    @Override
    public List<Teacher> getAllActiveTeacher() {
        return List.of();
    }

    @Override
    public String deactivateTeacher(long id) {
        return "";
    }
}
