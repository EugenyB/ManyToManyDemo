package org.example.manytomanydemo.repository;

import org.example.manytomanydemo.data.Meeting;
import org.example.manytomanydemo.data.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("select m from Meeting m where not exists (select 1 from Person p where m member of p.meetings and p.id = ?1)")
    List<Meeting> findAvailableMeetings(Integer id);
}