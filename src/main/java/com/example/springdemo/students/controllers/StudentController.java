package com.example.springdemo.students.controllers;

import java.util.List;

import com.example.springdemo.students.models.Student;
import com.example.springdemo.students.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/students")
@RestController
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudentService() {
    return studentService.getStudents();
  }

  @PostMapping
  public void addStudentService(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @DeleteMapping(path = "{id}")
  public void deleteStudentService(@PathVariable("id") long id) {
    studentService.deleteStudent(id);
  }

  @PutMapping(path = "{id}")
  public void updateStudentsService(@PathVariable("id") long id, @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
    studentService.updateStudent(id, name, email);
  }

  /*
   * java -jar <...> --server.port=<SERVER_PORT>
   * POSTGRES-SQL
   * Commands should have a final semicolon, if not the don't work
   * https://www.postgresql.org/docs/current/libpq-envars.html
   * usefulenvironment variables:9
   * PGUSER -> to set default user
   * PGPORT -> to set default port
   * PGDATABASE -> to set default DB
   * 
   * psql CMD:
   * psql -> to enter default user
   * \l -> see databases
   * \du -> see users
   * \c <DATABASE_NAME> -> connects to DB
   * \d -> List of relations
   * GRANT ALL PRIVILEGES ON DATABASE "student" TO postgres;
   * SELECT * FROM <DB_NAME>;
   * 
   * spring.datasource.url=jdbc:postgresql://localhost:5432/student
   * spring.datasource.username=postgres
   * spring.datasource.password=jorgedro
   * spring.jpa.hibernate.ddl-auto=create-drop
   * spring.jpa.show-sql=true
   * spring.jpa.properties.hibernate.dialect =
   * org.hibernate.dialect.PostgreSQLDialect
   * spring.jpa.properties.hibernate.format_sql=true
   * spring.jpa.hibernate.use-new-id-generator-mappings=false
   * spring.sql.init.mode=always
   * spring.sql.init.continue-on-error=true
   */
}
