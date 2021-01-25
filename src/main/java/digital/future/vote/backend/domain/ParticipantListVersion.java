package digital.future.vote.backend.domain;

import io.micronaut.data.annotation.DateCreated;
import lombok.Data;
import lombok.NonNull;

import java.time.Instant;

@Data
public class ParticipantListVersion {
    @NonNull Long listId;
    @NonNull Integer version;
    @DateCreated
    @NonNull Instant since;
}
