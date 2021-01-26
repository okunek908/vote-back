package digital.future.vote.backend.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.domain.PollQuestion;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.FutureOrPresent;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
public class PollDto {
    @NonNull String title;
    String description;

    @NonNull
    @FutureOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss")
    Instant timeStart;

    @NonNull
    @FutureOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss")
    Instant timeEnd;

    @NonNull List<PollQuestion> questions;

    public void updateEntity(@NonNull Poll poll) {
        poll.setTitle(title);
        poll.setDescription(description);
        poll.setTimeStart(timeStart);
        poll.setTimeEnd(timeEnd);
        poll.setQuestions(questions);
    }
}
