package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Person;
import com.example.springapp.repository.PersonRepo;
@Service
public class PersonService {
    @Autowired
    private PersonRepo repo;
    public Person addPerson(Person person) {
        return repo.save(person);
    }

    public List<Person> getPerson() {
        return repo.findAll();
    }

    public List <Person> sort(String age) {
        Sort sort = Sort.by(Sort.Direction.ASC,"age");
        return repo.findAll(sort);
    }
}
