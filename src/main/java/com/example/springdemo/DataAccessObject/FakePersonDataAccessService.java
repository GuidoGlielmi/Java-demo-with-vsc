package com.example.springdemo.DataAccessObject;

import java.util.ArrayList;
import java.util.List;
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
  
}
