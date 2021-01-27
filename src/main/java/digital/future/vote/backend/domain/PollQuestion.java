package digital.future.vote.backend.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Introspected
public class PollQuestion {
    @NonNull String question;
    @NonNull List<String> options;
}
