package com.voting.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voting.model.Poll;
import com.voting.request.Vote;
import com.voting.services.PollService;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    private final PollService pollService;
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("/test")
    public String testApi() {
        return "Controller is working!";
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @GetMapping()
    public List<Poll> getAllPoles(){
        return pollService.getAllPoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoles(@PathVariable Long id){
        return pollService.getPollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Voting
    //POST
    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote){
        pollService.vote(vote.getPollId(),vote.getOptionIndex());
    }
}


