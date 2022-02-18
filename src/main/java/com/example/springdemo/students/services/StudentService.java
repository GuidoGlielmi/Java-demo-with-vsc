package com.example.springdemo.students.services;

import java.util.List;

import com.example.springdemo.students.models.Student;
import com.example.springdemo.students.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//List.of(new Student(1L, "tuvieja", "asd@gmail.com"));
@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }
}
