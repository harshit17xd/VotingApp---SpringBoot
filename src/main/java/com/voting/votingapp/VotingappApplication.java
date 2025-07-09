package com.voting.votingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.voting")
@EnableJpaRepositories("com.voting.repositories")
@EntityScan("com.voting.model")
public class VotingappApplication {
    public static void main(String[] args) {
        SpringApplication.run(VotingappApplication.class, args);
    }
}
