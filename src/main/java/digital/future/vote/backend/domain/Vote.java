package digital.future.vote.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Data
@MappedEntity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Vote {
    // Generated vote unique id that identifies this vote action
    @Id
    @NonNull UUID voteUid = UUID.randomUUID();
    // references the poll
    @NonNull Long pollId;
    // user that performs this voting action
    @NonNull User user;

    @DateCreated
    @TypeDef(type = DataType.TIMESTAMP)
    @JsonFormat(pattern = "YYYY-MM-dd'T'HH:mm:ssZ")
    @NonNull OffsetDateTime timestamp;
    // user selection
    @NonNull Map<Long, String> answers;
    // additional properties related to vote action sourcing
    Map<String, String> voteProperties;
    // previous vote in case the user has changed his mind and wants to update their decision
    String previousVote;
}
