package com.example.demo.person.service;

import com.example.demo.person.domain.Person;
import com.example.demo.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        Optional<Person> obj = personRepository.findById(id);
        return obj.get();
    }

    public Person insert(Person obj) {
        return personRepository.save(obj);
    }

    public Person update(Long id, Person obj) {
        Person entity = personRepository.getOne(id);

        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());

        return personRepository.save(entity);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
