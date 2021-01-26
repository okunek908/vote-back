package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.QuestionAnswer;
import digital.future.vote.backend.domain.Vote;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class VoteDto {
    @NonNull Long pollId;

    @NonNull List<QuestionAnswer> answers;

    public void updateEntity(Vote vote) {
        vote.setPollId(pollId);
        vote.setAnswers(answers);
    }
}
