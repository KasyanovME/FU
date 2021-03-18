package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.Person;
import service.PersonService;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiController {
    private final PersonService personService;
    @Autowired
    public RestApiController(PersonService personService){
        this.personService=personService;
    }
    @PostMapping(value = "/api/person")
    public ResponseEntity<?> create(@RequestBody Person person){
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/person")
    public ResponseEntity<List<Person>> findAll{
        final List<Person> personList = personService.findAll();
        return personList != null && !personList.isEmpty();
                ? new ResponseEntity<>(personList, HttpStatus.OK)
                : new ResponseEntity<>(personList, HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/api/person")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<Person> person = personService.findById(id);
        return person.isPresent()
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(person, HttpStatus.NOT_FOUND);
    }
}
