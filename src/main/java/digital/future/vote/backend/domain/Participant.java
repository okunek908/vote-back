package digital.future.vote.backend.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.TypeDef;
import lombok.*;

import javax.annotation.concurrent.Immutable;


@Value
@Immutable
//@TypeDef(type = DataType.STRING)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
//@Introspected //<-- introspected make json deserialization fail for some reason TODO: WHY?
public class Participant {
    // Opaque random-like user id
    @JsonValue
    @NonNull String voterId;

    @Creator
    public static Participant fromString(String voterId) {
        return new Participant(voterId);
    }
}
