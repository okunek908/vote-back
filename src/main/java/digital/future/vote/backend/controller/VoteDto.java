package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.Vote;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;

@Data
@NoArgsConstructor
public class VoteDto {
    @NonNull Long pollId;

    @NonNull Map<Long, String> answers;

    public void updateEntity(Vote vote) {
        vote.setPollId(pollId);
        vote.setAnswers(answers);
    }
}
