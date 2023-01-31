package com.marmo.personapiwithdb.service;

import com.marmo.personapiwithdb.model.Person;
import com.marmo.personapiwithdb.repository.PersonRepository;
import com.marmo.personapiwithdb.request.PersonRequest;
import com.marmo.personapiwithdb.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements  PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public MessageResponse createPerson (PersonRequest personRequest) {
        Person newPerson = new Person();

        newPerson.setNome(personRequest.getNome());
        newPerson.setCpf(personRequest.getCpf());
        newPerson.setRg(personRequest.getRg());
        newPerson.setDataNascimento(personRequest.getDataNascimento());
        newPerson.setTelefone(personRequest.getTelefone());
        newPerson.setEmail(personRequest.getEmail());
        newPerson.setEstadoCivil(personRequest.getEstadoCivil());

        personRepository.save(newPerson);

        return new MessageResponse("Nova pessoa cadastrado com sucesso!");
    }

    @Override
    public Optional<Person> updatePerson (Integer personId, PersonRequest personRequest){
        Optional<Person> person = personRepository.findById(personId);

        if(person.isEmpty()){
            throw new RuntimeException();
        }
        else
            person.get().setNome(personRequest.getNome());
            person.get().setCpf(personRequest.getCpf());
            person.get().setRg(personRequest.getRg());
            person.get().setDataNascimento(personRequest.getDataNascimento());
            person.get().setTelefone(personRequest.getTelefone());
            person.get().setEmail(personRequest.getEmail());
            person.get().setEstadoCivil(personRequest.getEstadoCivil());
            personRepository.save(person.get());

            return person;
    }

    @Override
    public Person getSinglePerson(Integer personId){
        return personRepository.findById(personId).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    @Override
    public void deletePerson(Integer personId){
        if(personRepository.getById(personId).getId().equals(personId)){
            personRepository.deleteById(personId);
        }
        else throw new RuntimeException();
    }
}
