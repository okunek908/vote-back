package digital.future.vote.backend.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Participant {
    @NonNull String id;
    String gender;
    Integer bornYear;
}
