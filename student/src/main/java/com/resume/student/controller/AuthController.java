package com.resume.student.controller;

import com.resume.student.entity.Teacher;
import com.resume.student.repository.TeacherRepository;
import com.resume.student.service.TeacherService;
import com.resume.student.util.JwtFilter;
import com.resume.student.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerTeacher(@RequestBody Teacher teacher) {
        if (teacherRepository.findByEmail(teacher.getEmail()).isPresent()) {
            return new ResponseEntity<>("Email already exist..!!", HttpStatus.CONFLICT);
        }
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacherService.createTeacher(teacher);
        return new ResponseEntity<>("Successfully created..!!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginTeacher(@RequestBody Map<String,String> body){
        String email=body.get("email");
        String password = body.get("password");
        var teacherOptional=teacherRepository.findByEmail(email);
        if(teacherOptional.isEmpty()){
            return new ResponseEntity<>("Teacher not Registered..!!", HttpStatus.UNAUTHORIZED);
        }
        Teacher tech=teacherOptional.get();

        if(!passwordEncoder.matches(password,tech.getPassword())){
            return new ResponseEntity<>("Incorrect password..!!", HttpStatus.UNAUTHORIZED);
        }
        String token=jwtUtil.generateToken(email);

        return ResponseEntity.ok(Map.of("Token",token));
    }

    @GetMapping("/getAllActiveTeacher")
    public List<Teacher> getAllActiveTeacher() {
        return teacherService.getAllActiveTeacher();
    }
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateTeacher(@PathVariable long id) {
        return ResponseEntity.ok(teacherService.deactivateTeacher(id));
    }
}
