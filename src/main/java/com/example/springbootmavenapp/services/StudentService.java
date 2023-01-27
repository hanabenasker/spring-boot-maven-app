package com.example.springbootmavenapp.services;

import com.example.springbootmavenapp.models.Student;
import com.example.springbootmavenapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmavenapp.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student) throws ResourceNotFoundException {

        Student createdStudent = this.studentRepository.save(student);
        return createdStudent;
    }

    public List<Student> getAllStudents() throws ResourceNotFoundException {

        List<Student> students = this.studentRepository.findAll();
        return students;
    }

    public Student getStudentById(Long studentId) throws ResourceNotFoundException {

        Optional<Student> studentData = this.studentRepository.findById(studentId);
        if(studentData.isPresent()){
            Student student = studentData.orElseThrow(()-> new ResourceNotFoundException("student not found"));
            return student;
        }else{
            throw new  ResourceNotFoundException("Not student matches.");
        }
    }
}
