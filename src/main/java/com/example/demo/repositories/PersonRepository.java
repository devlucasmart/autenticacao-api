package com.example.demo.repositories;

import com.example.demo.enitities.Person;


@Repository
public class PersonRepository extends JpaRepository<Person, String> {
    Person findByUsername(String personname);
}
