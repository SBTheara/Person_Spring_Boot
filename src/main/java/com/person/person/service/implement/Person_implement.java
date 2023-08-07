package com.person.person.service.implement;

import com.person.person.model.Person;
import com.person.person.repository.Person_repository;
import com.person.person.service.Person_service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Person_implement implements Person_service {
    private Person_repository person_repository;

    public Person_implement(Person_repository person_repository) {
        this.person_repository = person_repository;
    }

    @Override
    public Person savePerson(Person person) {
        return person_repository.save(person);
    }

    @Override
    public List<Person> getPerson() {
        return person_repository.findAll();
    }

    @Override
    public Person getbyID(Long id) {
        return person_repository.findById(id).get();
    }

    @Override
    public Person updatePerson(Person person, Long id) {
        Person person1=person_repository.findById(id).get();
        person1.setFirstname(person.getFirstname());
        person1.setLastname(person.getLastname());
        person1.setDayofbirth(person.getDayofbirth());
        person1.setAge(person.getAge());
        person1.setAddress(person.getAddress());
        person1.setMaritalstatus(person.getMaritalstatus());
        person1.setJob(person.getJob());
        person_repository.save(person1);
        return person1;
    }

    @Override
    public void deletePerson(Long id) {
        person_repository.deleteById(id);
    }
}
