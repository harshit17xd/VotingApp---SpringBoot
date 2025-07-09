package com.voting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.voting.model.Poll;
import com.voting.repositories.PollRepository;

@Service
public class PollService {

    private final PollRepository pollRepository;
    
    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }
    
    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPoles() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    
}
