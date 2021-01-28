package digital.future.vote.backend.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import digital.future.vote.backend.domain.Vote;
import digital.future.vote.backend.domain.VoteId;
import digital.future.vote.backend.repo.VoteRepo;
import digital.future.vote.backend.util.UID;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Controller("vote")
public class VoteController {
    @Inject
    VoteRepo voteRepo;

    @Post
    public UID registerVote(@Body VoteDto dto, @JsonProperty("updateVote") @Nullable String updateVote)
            throws UID.FormatException {
        Vote vote = new Vote();
        dto.updateEntity(vote);
        vote.setVoterId("TODO!!!");//TODO
        if (updateVote != null && !updateVote.isEmpty()) {
            //TODO: check that user attempts to update their own vote
            //TODO: check that the vote to be updated was not yet updated
            vote.setUpdatedVoteUid(new VoteId(updateVote));
        } else {
            //TODO: check that the user has not yet voted
        }
        return voteRepo.save(vote).getVoteUid();
    }


    @Get("uid/{uid}")
    public Vote getVote(@NotNull VoteId uid) {
        //TODO: ensure this is current user's vote
        return voteRepo.findById(uid).orElseThrow();
    }
}
