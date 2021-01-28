package digital.future.vote.backend.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswer {
    @NonNull Integer question;
    @NonNull Integer answer;
}
