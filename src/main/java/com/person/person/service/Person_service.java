package com.person.person.service;

import com.person.person.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Person_service {
    Person savePerson(Person person);
    List<Person> getPerson();
    Person getbyID(Long id);
    Person updatePerson(Person person,Long id);
    void deletePerson(Long id);
}
