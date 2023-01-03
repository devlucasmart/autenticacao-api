package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.enitities.Person;

@Repository
public class PersonRepository extends JpaRepository<Person, String> {
    Person findByUsername(String personname);
}
