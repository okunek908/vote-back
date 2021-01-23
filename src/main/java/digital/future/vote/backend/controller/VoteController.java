package digital.future.vote.backend.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import digital.future.vote.backend.domain.Vote;
import digital.future.vote.backend.repo.VoteRepo;
import digital.future.vote.backend.util.UID;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Controller("vote")
public class VoteController {
    @Inject
    VoteRepo voteRepo;

    @Post
    public UID registerVote(@Body VoteDto dto, @JsonProperty("updateVote") String updateVote)
            throws UID.UidFormatException {
        Vote vote = new Vote();
        dto.updateEntity(vote);
        if (updateVote != null) {
            //TODO: check that user attempts to update their own vote
            //TODO: check that the vote to be updated was not yet updated
            vote.setPreviousVoteUid(new UID(updateVote));
        } else {
            //TODO: check that the user has not yet voted
        }
        return voteRepo.save(vote).getVoteUid();
    }


    @Get("uid/{uid}")
    public Vote getVote(@NotNull UID uid) {
        //TODO: ensure this is current user's vote
        return voteRepo.findById(uid).orElseThrow();
    }
}
