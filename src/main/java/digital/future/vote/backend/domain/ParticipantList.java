package digital.future.vote.backend.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import lombok.Data;
import lombok.NonNull;

@Data
public class ParticipantList {
    @Id
    @GeneratedValue
    Long id;

    @NonNull String listName;

}
