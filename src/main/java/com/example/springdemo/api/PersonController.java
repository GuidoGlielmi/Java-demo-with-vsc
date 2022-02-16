package com.example.springdemo.api;

import java.util.List;

import com.example.springdemo.model.Person;
import com.example.springdemo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/person")
@RestController
public class PersonController {
  private final PersonService personService;
 
  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public void addPerson(@RequestBody Person person) { //@RequestBody turns the body of a request into a "Person"
    personService.addPerson(person);
  }
  @GetMapping
  public List<Person> getAllPeople() {
    return personService.getAllPeople();
  }
}
