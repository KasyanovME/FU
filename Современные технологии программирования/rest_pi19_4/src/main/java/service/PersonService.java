package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.Person;
import repository.PersonRepository;

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

}
