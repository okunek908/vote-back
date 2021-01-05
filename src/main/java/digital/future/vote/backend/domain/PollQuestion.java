package digital.future.vote.backend.domain;

import lombok.Data;

import java.util.List;

@Data
public class PollQuestion {
    String question;
    List<String> answerOptions;
}
