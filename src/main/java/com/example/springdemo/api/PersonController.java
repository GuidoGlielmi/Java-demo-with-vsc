package com.example.springdemo.api;

import java.util.List;
import java.util.UUID;

import com.example.springdemo.model.Person;
import com.example.springdemo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
  
  @GetMapping(path = "{id}")
  public Person personById(@PathVariable("id") UUID id) {
    return personService.getPersonById(id).orElse(null);
  }
  @DeleteMapping(path = "{id}")
  public void deletePersonById(@PathVariable("id") UUID id) {
    personService.deletePerson(id); 
  }
  @PutMapping(path = "{id}")
  public void updatePersonById(@PathVariable("id") UUID id, @RequestBody Person newPerson) {
    personService.updatePerson(id, newPerson);
  }
}
