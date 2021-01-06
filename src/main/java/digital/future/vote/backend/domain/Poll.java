package digital.future.vote.backend.domain;

import io.micronaut.data.annotation.*;
import io.micronaut.data.jdbc.annotation.JoinTable;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@MappedEntity
@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Poll {
    @Id
    @GeneratedValue
    Long id;
    @NonNull String title;
    String description;
    @NonNull LocalDateTime timeStart;
    @NonNull LocalDateTime timeEnd;
    @DateCreated
    ZonedDateTime created;
    @DateUpdated
    ZonedDateTime updated;

//    @NonNull List<PollQuestion> questions;
}
