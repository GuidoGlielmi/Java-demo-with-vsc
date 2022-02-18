package com.example.springdemo.DataAccessObject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.springdemo.model.Person;

public interface PersonDao {
  /*
   * This is an interface that uses the "Person" model.
   * With this interface, any implementation can be used, as it has
   * an add, getAll, getById, update and delete methods.
   */
  int insertPerson(UUID id, Person person);

  default int insertPerson(Person person) {
    // This is an overload
    // The access level of a default modifier is only within the package.
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }

  List<Person> selectAllPeople();

  Optional<Person> selectPersonById(UUID id);

  int deletePersonById(UUID id);

  int updatePersonById(UUID id, Person person);

}
