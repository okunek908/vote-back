package digital.future.vote.backend.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
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
