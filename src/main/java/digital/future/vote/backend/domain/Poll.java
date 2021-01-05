package digital.future.vote.backend.domain;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class Poll {
    Long id;
    @NonNull String title;
    String description;
    @NonNull LocalDateTime timeStart;
    @NonNull LocalDateTime timeEnd;
    ZonedDateTime created;
    @NonNull List<PollQuestion> questions;
}
