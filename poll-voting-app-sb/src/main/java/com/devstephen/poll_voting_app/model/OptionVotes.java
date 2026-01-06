package com.devstephen.poll_voting_app.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class OptionVotes {
    private String voteOptions;
    private Long voteCount = 0L;
}
