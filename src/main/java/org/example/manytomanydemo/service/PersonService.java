package org.example.manytomanydemo.service;

import lombok.RequiredArgsConstructor;
import org.example.manytomanydemo.data.Meeting;
import org.example.manytomanydemo.data.Person;
import org.example.manytomanydemo.repository.MeetingRepository;
import org.example.manytomanydemo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository repository;
    private final MeetingRepository meetingRepository;

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

    public Set<Meeting> findMeetings(Integer id) {
        Optional<Person> optionalPerson = repository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get().getMeetings();
        } else {
            return Collections.emptySet();
        }
    }

    public List<Meeting> findAvailableMeetings(Integer id) {
        return repository.findAvailableMeetings(id);
    }

    public void addMeeting(Integer pid, Integer mid) {
        repository.findById(pid).ifPresent(person -> {
            meetingRepository.findById(mid).ifPresent(meeting -> {
                person.getMeetings().add(meeting);
                repository.save(person);
            });
        });
    }

    public void removeMeeting(Integer pid, Integer mid) {
        repository.findById(pid).ifPresent(person -> {
            person.getMeetings().removeIf(meeting -> meeting.getId().equals(mid));
            repository.save(person);
        });
    }

    public void deletePerson(Integer id) {
        repository.deleteById(id);
    }

    public void update(Integer id, String name, Integer age) {
        repository.findById(id).ifPresent(person -> {
            person.setName(name);
            person.setAge(age);
            repository.save(person);
        });
    }
}
