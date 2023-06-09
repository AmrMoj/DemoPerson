package com.test.demo.service;


import com.test.demo.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonService {
    Person addPerson(Person person);
    List<Person> getAllPersons();

}
