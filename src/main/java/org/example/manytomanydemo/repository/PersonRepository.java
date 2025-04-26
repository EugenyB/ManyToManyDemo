package org.example.manytomanydemo.repository;

import org.example.manytomanydemo.data.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}