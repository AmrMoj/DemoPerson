package com.test.demo.service;

import com.test.demo.entities.Person;
import com.test.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService implements IPersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        log.info("Adding Person: "+ person.getFirstName()+ " "+ person.getLastName());
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAllByLastNameIsNotNullOrderByFirstName();
    }
}
