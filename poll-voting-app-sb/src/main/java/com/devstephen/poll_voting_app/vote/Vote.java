package com.devstephen.poll_voting_app.vote;

import lombok.Data;

@Data
public class Vote {
    private Long pollId;
    private int optionIndex;
}
