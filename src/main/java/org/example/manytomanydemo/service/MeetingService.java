package org.example.manytomanydemo.service;

import lombok.RequiredArgsConstructor;
import org.example.manytomanydemo.data.Meeting;
import org.example.manytomanydemo.repository.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository repository;

    public List<Meeting> findAll() {
        return repository.findAll();
    }

}
