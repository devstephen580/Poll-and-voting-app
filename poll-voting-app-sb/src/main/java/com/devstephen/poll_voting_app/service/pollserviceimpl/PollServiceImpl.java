package com.devstephen.poll_voting_app.service.pollserviceimpl;

import com.devstephen.poll_voting_app.model.OptionVotes;
import com.devstephen.poll_voting_app.model.Poll;
import com.devstephen.poll_voting_app.repositories.PollRepo;
import com.devstephen.poll_voting_app.service.PollService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollServiceImpl implements PollService {
    private PollRepo pollRepo;

    public PollServiceImpl(PollRepo pollRepo) {
        this.pollRepo = pollRepo;
    }

    @Override
    public Poll createPoll(Poll poll) {
        return pollRepo.save(poll);
    }

    @Override
    public List<Poll> getAllPoll() {
        return pollRepo.findAll();
    }

    @Override
    public Optional<Poll> getPollById(Long id) {
        return pollRepo.findById(id);


//        return pollWithId.orElse(null);
    }

    @Override
    public void vote(Long pollId, int optionIndex) {
        Poll pollById = pollRepo.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found"));
        List<OptionVotes> options = pollById.getOptions();

        if (optionIndex< 0 || optionIndex >= options.size()){
            throw new IllegalArgumentException("Invalid option index");
        }

        OptionVotes selectedOption = options.get(optionIndex);
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
        pollRepo.save(pollById);
    }

//    @Override
//    public void vote(Poll poll) {
//        List<OptionVotes> options = poll.getOptions();
//        options.add()
//    }
}
