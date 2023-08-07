package com.person.person.repository;

import com.person.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Person_repository extends JpaRepository<Person,Long> {
}
