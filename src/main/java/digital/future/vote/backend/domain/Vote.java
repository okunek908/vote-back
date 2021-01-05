package digital.future.vote.backend.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
public class Vote {
    @NonNull Long pollId;
    @NonNull Map<Long, String> answers;
}
