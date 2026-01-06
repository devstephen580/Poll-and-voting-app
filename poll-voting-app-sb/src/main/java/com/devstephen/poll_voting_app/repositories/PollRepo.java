package com.devstephen.poll_voting_app.repositories;

import com.devstephen.poll_voting_app.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PollRepo extends JpaRepository<Poll, Long> {
}
