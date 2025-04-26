package org.example.manytomanydemo.service;

import lombok.RequiredArgsConstructor;
import org.example.manytomanydemo.data.Person;
import org.example.manytomanydemo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findById(Integer integer) {
        return repository.findById(integer);
    }

    public Person save(String name, int age) {
        Person p = new Person(name, age);
        return repository.save(p);
    }
}
