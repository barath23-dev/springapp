package com.example.springapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Person;
import com.example.springapp.service.PersonService;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping("/api/person")
    public ResponseEntity<?> addPerson(@RequestBody Person person){
        try {
            return new ResponseEntity<>(service.addPerson(person),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/person")
    public ResponseEntity<?>getPerson(){
        try {
            return new ResponseEntity<>(service.getPerson(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/person/byAge")
    public ResponseEntity<?>sort(@RequestParam String age){
        try {
            return new ResponseEntity<>(service.sort(age),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
