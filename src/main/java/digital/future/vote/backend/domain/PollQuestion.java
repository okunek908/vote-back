package digital.future.vote.backend.domain;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PollQuestion {
    @NonNull String question;
    @NonNull List<String> options;
}
