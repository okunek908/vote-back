package digital.future.vote.backend.domain;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class QuestionAnswer {
    @NonNull Integer question;
    @NonNull Integer answer;
}
