package com.voting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voting.model.Poll;

@Repository
public interface  PollRepository extends JpaRepository<Poll, Long> {
    
}
