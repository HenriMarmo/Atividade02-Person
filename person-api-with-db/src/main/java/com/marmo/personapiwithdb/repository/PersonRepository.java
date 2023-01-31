package com.marmo.personapiwithdb.repository;

import com.marmo.personapiwithdb.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
