package com.marmo.personapiwithdb.controller;

import com.marmo.personapiwithdb.model.Person;
import com.marmo.personapiwithdb.request.PersonRequest;
import com.marmo.personapiwithdb.response.MessageResponse;
import com.marmo.personapiwithdb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllpeople(){
        List<Person> people = personService.getAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable ("id") Integer id) {
        Person person = personService.getSinglePerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addCar(@RequestBody PersonRequest person) {
        MessageResponse newPerson = personService.createPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public Optional<Person> updatePerson(@PathVariable Integer id, @RequestBody PersonRequest person){
        return personService.updatePerson(id,person);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable ("id") Integer id){
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
