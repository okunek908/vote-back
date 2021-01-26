package digital.future.vote.backend.domain;

import io.micronaut.data.annotation.Embeddable;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.*;


@Value
@Embeddable
@TypeDef(type = DataType.STRING)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Participant {
    // Opaque random-like user id
    @NonNull String voterId;
}
