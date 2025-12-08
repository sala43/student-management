package com.resume.student.controller;

import com.resume.student.entity.Student;
import com.resume.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;


    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }


    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("deleteStudentById/{id}")
    public String deleteStudentById(@PathVariable long id) {
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id,@Valid @RequestBody Student student,BindingResult result) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        studentService.updateStudent(id, student);
        return ResponseEntity.ok( Map.of("message", "Student updated successfully"));

        }
}
