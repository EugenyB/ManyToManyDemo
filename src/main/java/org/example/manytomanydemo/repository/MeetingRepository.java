package org.example.manytomanydemo.repository;

import org.example.manytomanydemo.data.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
}
