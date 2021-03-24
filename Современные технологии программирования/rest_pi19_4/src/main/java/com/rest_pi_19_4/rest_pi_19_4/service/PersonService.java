package com.rest_pi_19_4.rest_pi_19_4.service;

import com.rest_pi_19_4.rest_pi_19_4.entity.Person;
import com.rest_pi_19_4.rest_pi_19_4.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void create(Person person){
        personRepository.save(person);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id){
        return personRepository.findById(id);
    }

    public void updatePerson(Person person, Long id) {
        if (findById(id).isPresent()) {
            person.setId(id);
            personRepository.save(person);
        }
    }

    public boolean deletePerson(Long id) {
        if (findById(id).isPresent()) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        personRepository.deleteAll();
    }
}
