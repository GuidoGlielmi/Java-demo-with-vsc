package com.example.springdemo.students.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.example.springdemo.students.models.Student;
import com.example.springdemo.students.repositories.StudentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student jorge = new Student("jorge", "asd@gmail.com", LocalDate.of(2000, Month.JANUARY, 5));
      Student asdasd = new Student("asdasd", "asdasd@gmail.com", LocalDate.of(2004, Month.JANUARY, 5));
      repository.saveAll(List.of(jorge, asdasd));
      // Hibernate is running when invoking saveAll
    };
  }

}
