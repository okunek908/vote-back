package digital.future.vote.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import digital.future.vote.backend.util.UID;
import io.micronaut.data.annotation.*;
import io.micronaut.data.jdbc.annotation.ColumnTransformer;
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
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss")
    Instant timeStart;

    @NonNull
    @TypeDef(type = DataType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ss")
    Instant timeEnd;

    @DateCreated
    @TypeDef(type = DataType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ssZ")
    Instant created;

    @DateUpdated
    @TypeDef(type = DataType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ssZ")
    Instant updated;

    @TypeDef(type = DataType.JSON)
    List<PollQuestion> questions;

    @TypeDef(type = DataType.JSON)
    ParticipantList participantList;

    // ID that is to be used in Poll URL
    @ColumnTransformer()
    UID publicID;

    public Status getStatus() {
        Instant now = Instant.now();
        if (now.isAfter(timeEnd)) {
            return Status.ENDED;
        }
        if (now.isAfter(timeStart)) {
            return Status.ACTIVE;
        }
        if (publicID != null) {
            return Status.PUBLISHED;
        }
        return Status.DRAFT;
    }
}
