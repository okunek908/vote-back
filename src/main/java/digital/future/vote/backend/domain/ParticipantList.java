package digital.future.vote.backend.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micronaut.data.annotation.*;
import lombok.*;

import java.util.List;

@Data
@MappedEntity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class ParticipantList {
    @Id
    @GeneratedValue
    Long id;

    @NonNull
    String title;

    String description;

    List<Participant> participants;
}
