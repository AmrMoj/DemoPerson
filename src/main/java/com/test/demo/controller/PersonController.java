package com.test.demo.controller;


import com.test.demo.entities.Person;
import com.test.demo.entities.PersonDTO;
import com.test.demo.service.IPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/persons")
@Api(tags = "Person management")
public class PersonController {

    private final IPersonService personService;

    @ApiOperation(value="Add new person")
    @PostMapping()
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @ApiOperation(value="Get all persons")
    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        List<PersonDTO> personDTOS = new ArrayList<>();
        for (Person person : persons) {

            PersonDTO personDTO = new PersonDTO();
            personDTO.setId(person.getId());
            personDTO.setFirstName(person.getFirstName());
            personDTO.setLastName(person.getLastName());
            personDTO.setBirthDate(person.getBirthDate());

            // Calcul de l'âge actuel
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = LocalDate.parse(person.getBirthDate());
            int age = Period.between(birthDate, currentDate).getYears();

            personDTO.setAge(age);

            personDTOS.add(personDTO);
        }
        return ResponseEntity.ok(personDTOS);
    }
}