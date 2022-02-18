package com.example.springdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.springdemo.DataAccessObject.PersonDao;
import com.example.springdemo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final PersonDao personDao;

  @Autowired
  public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
    // The service is used to separate the controller from the bussiness logic
    // This receives an instance of an implementation of PersonDao ONCE
    // in order for this to happen, the implementation of PersonDao
    // IS intanciated. The @Qualifier selects the specific implementation
    // after running the server
    // (FakePersonData in this case)
    // In this case, the parameter type is of an instance, so anything added
    // through implementations can't be accessed, because it is impossible
    // to know in advance (in compilation) which implementation
    // is going to be used.
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return personDao.insertPerson(person); // this references the default method of the interface

  }

  public List<Person> getAllPeople() {
    return personDao.selectAllPeople();
  }

  public Optional<Person> getPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }

  public int deletePerson(UUID id) {
    return personDao.deletePersonById(id);
  }

  public int updatePerson(UUID id, Person newPerson) {
    return personDao.updatePersonById(id, newPerson);
  }
}
