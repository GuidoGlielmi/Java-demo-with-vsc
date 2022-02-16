package com.example.springdemo.DataAccessObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.springdemo.model.Person;

import org.springframework.stereotype.Repository;

@Repository("fakeDao") //allows multiple implementations (as PersonDao is an interface)
public class FakePersonDataAccessService implements PersonDao {
  private static List<Person> DB = new ArrayList<>();
  
  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return 1;
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    return DB.stream().filter(person-> person.getId().equals(id)).findFirst();
  }

  @Override
  public int deletePersonById(UUID id) {
    Optional<Person> selectedPerson = selectPersonById(id);
    if(selectedPerson.isEmpty()) return 0;
    DB.remove(selectedPerson.get()); // "Optional" method, outputs the element if any. 
    return 1;
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    return selectPersonById(id).map(p->{
      int index = DB.indexOf(p);
      if(index != -1) {
        DB.set(index, new Person(id, person.getName()));
        return 1;
      }
      return 0;
    }).orElse(0);

  }
  
}
