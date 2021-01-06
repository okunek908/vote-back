package digital.future.vote.backend.domain;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class PollQuestion {
    @NonNull String question;
    List<String> options;
}
