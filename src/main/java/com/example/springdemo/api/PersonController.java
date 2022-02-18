package com.example.springdemo.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.example.springdemo.model.Person;
import com.example.springdemo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/person")
@RestController // -> @ResponseBody AND @Controller
public class PersonController {
  // PersonService contains the logic the controller calls when receiving requests
  @Autowired
  private PersonService personService;
  // this instance has a personDao implementation (FakePersonDataAccessService)
  // For example, this:
  // personService.personDao.insertPerson(new Person(UUID.randomUUID(), "guido"));
  // would be the same as:
  // personService.addPerson(new Person(UUID.randomUUID(), "guido"));
  /*
   * @Autowired
   * // this forces the execution of whatever method is underneat
   * // injecting, if necessary, any other bean (class's instance)
   * public PersonController(PersonService personService) {
   * // This receives an instance of personService ONCE after running the server
   * // in order for this to happen, PersonService IS intantiated
   * // System.out.println(personService.personDao) This outputs the implemented
   * // PersonDao, which in this case is FakePersonDataAccessService, but since we
   * // are referencing the interface, no properties of the actual implementation
   * can
   * // be accessed.
   * this.personService = personService;
   * personService.addPerson(new Person(UUID.randomUUID(), "guido"));
   * }
   */

  @PostMapping()
  public void addPerson(@RequestBody @Valid @NonNull Person person) {
    // @RequestBody turns the body of a request into a "Person"
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
  public void updatePersonById(@PathVariable("id") UUID id, @RequestBody @Valid @NonNull Person newPerson) {
    personService.updatePerson(id, newPerson);
  }
}
