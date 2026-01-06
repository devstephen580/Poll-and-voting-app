package com.devstephen.poll_voting_app.service;

import com.devstephen.poll_voting_app.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PollService {
    Poll createPoll(Poll poll);

    List<Poll> getAllPoll();

    Optional<Poll> getPollById(Long id);

    void vote (Long pollId,  int optionIndex);
}
