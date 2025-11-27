package com.resume.student.service;

import com.resume.student.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher createTeacher(Teacher tech);
    public Teacher getTeacherById(long id);
    List<Teacher> getAllActiveTeacher();
    String deactivateTeacher(long id);
}
