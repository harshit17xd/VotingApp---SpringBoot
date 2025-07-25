package com.voting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.voting.model.OptionVote;
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

    public void vote(Long pollId, int optionIndex) {
        //get poll from DB
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found!!"));

        //get all options
        List<OptionVote> options = poll.getOptions();

        //if index is not valid, throw error
        if(optionIndex < 0 || optionIndex >= options.size()){
            throw new IllegalArgumentException("Invalid option index");
        }

        //option
        OptionVote selectedOption = options.get(optionIndex);

        //increment vote for selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        //save incremented vote option into db
        pollRepository.save(poll);
    }

    
}
