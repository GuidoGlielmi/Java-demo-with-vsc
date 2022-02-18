package com.example.springdemo.students.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

  public void addStudent(Student student) {
    Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
    if (studentEmail.isPresent()) {
      throw new IllegalStateException("Email taken");
    }
    studentRepository.save(student);
  }

  public void deleteStudent(long id) {
    if (!studentRepository.existsById(id)) {
      throw new IllegalStateException("ID does not exists");
    }
    studentRepository.deleteById(id);
  }

  @Transactional // makes it unnecessary to use Query, only setters from the model
  // the entity goes into a manage state
  public void updateStudent(long id, String name, String email) {
    if (!studentRepository.existsById(id)) {
      throw new IllegalStateException("ID does not exists");
    }
    if (studentRepository.findStudentByEmail(email).isPresent()) {
      throw new IllegalStateException("Email already taken");
    }
    Student foundStudent = studentRepository.getById(id);
    if (name != null && !name.isBlank()) {
      foundStudent.setName(name);
    }

    if (email != null && !email.isBlank()) {
      foundStudent.setEmail(email);
    }

  }
}
