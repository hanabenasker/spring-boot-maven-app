package com.example.springbootmavenapp.controllers;


import com.example.springbootmavenapp.models.Student;
import com.example.springbootmavenapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public List<Student> getStudents(){
        List<Student> students = this.studentService.getAllStudents();
        return students;
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long studentId)
    {
        Student student = this.studentService.getStudentById(studentId);
        return student;
    }

    @PostMapping("/create")
    public Student createNewStudent(@RequestBody Student newStudent)
    {
        Student student = this.studentService.createStudent(newStudent);
        return student;
    }
}
