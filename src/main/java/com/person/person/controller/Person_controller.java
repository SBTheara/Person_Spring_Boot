package com.person.person.controller;

import com.person.person.model.Person;
import com.person.person.service.Person_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class Person_controller {
    private Person_service person_service;

    public Person_controller(Person_service person_service) {
        this.person_service = person_service;
    }
    @PostMapping("/post")
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        return new ResponseEntity<Person> ((Person) person_service.savePerson(person),HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public List<Person> getPerson(){
        return person_service.getPerson();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getbyID(@PathVariable("id") Long id){
        return new ResponseEntity<>(person_service.getbyID(id),HttpStatus.OK);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody Person person){
        return new ResponseEntity<>(person_service.updatePerson(person,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long id){
        person_service.deletePerson(id);
        return new ResponseEntity<>("This person was delete", HttpStatus.OK);
    }
}
