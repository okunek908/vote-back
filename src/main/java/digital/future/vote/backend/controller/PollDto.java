package digital.future.vote.backend.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import digital.future.vote.backend.domain.ParticipantList;
import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.domain.PollQuestion;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.FutureOrPresent;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@Introspected
public class PollDto {
    @NonNull String title;
    String description;

    @NonNull
    @FutureOrPresent
    Instant timeStart;

    @NonNull
    @FutureOrPresent
    Instant timeEnd;

    @NonNull List<PollQuestion> questions;

    ParticipantList participantList;

    public void updateEntity(@NonNull Poll poll) {
        poll.setTitle(title);
        poll.setDescription(description);
        poll.setTimeStart(timeStart);
        poll.setTimeEnd(timeEnd);
        poll.setQuestions(questions);
        poll.setParticipantList(participantList);
    }
}
