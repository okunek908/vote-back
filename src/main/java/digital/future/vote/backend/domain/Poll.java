package digital.future.vote.backend.domain;

import digital.future.vote.backend.util.UID;
import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@MappedEntity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Poll {
    public enum Status {DRAFT, PUBLISHED, ACTIVE, ENDED}

    @Id
    @GeneratedValue
    Long id;

    @NonNull
    String title;

    String description;

    @NonNull
    @TypeDef(type = DataType.TIMESTAMP)
    Instant timeStart;

    @NonNull
    @TypeDef(type = DataType.TIMESTAMP)
    Instant timeEnd;

    @DateCreated
    @TypeDef(type = DataType.TIMESTAMP)
    Instant created;

    @DateUpdated
    @TypeDef(type = DataType.TIMESTAMP)
    Instant updated;

    @TypeDef(type = DataType.JSON)
    List<PollQuestion> questions;

    @TypeDef(type = DataType.JSON)
    ParticipantList participantList;

    // UID that is to be used in Poll URL
    UID publicUid;

    @Transient
    public Status getStatus() {
        Instant now = Instant.now();
        if (now.isAfter(timeEnd)) {
            return Status.ENDED;
        }
        if (now.isAfter(timeStart)) {
            return Status.ACTIVE;
        }
        if (publicUid != null) {
            return Status.PUBLISHED;
        }
        return Status.DRAFT;
    }
}
