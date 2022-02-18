package com.example.springdemo.students.models;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

@Entity
@Table
public class Student {

  @Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_secuence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;
  private String name;
  private String email;
  private LocalDate birth;
  @Transient // this makes not necessary to make an age column, but instead calculated.
  private Integer age;

  public Student() {
  }

  public Student(String name, String email, LocalDate birth) {
    // ID is not necessary as it is automatically generated by postgres
    this.name = name;
    this.email = email;
    this.birth = birth;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

  public LocalDate getBirth() {
    return this.birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  public Integer getAge() {
    return Period.between(birth, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
