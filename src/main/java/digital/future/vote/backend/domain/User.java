package digital.future.vote.backend.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull String userId;
    @NonNull String authorizationCode;
}
