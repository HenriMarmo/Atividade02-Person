package com.marmo.personapiwithdb.service;

import com.marmo.personapiwithdb.response.MessageResponse;
import com.marmo.personapiwithdb.model.Person;
import com.marmo.personapiwithdb.request.PersonRequest;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    MessageResponse createPerson(PersonRequest personRequest);

    Optional<Person> updatePerson(Integer personId, PersonRequest personRequest);

    void deletePerson(Integer personId);

    Person getSinglePerson(Integer personId);

    List<Person> getAllPeople();
}
