package digital.future.vote.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import digital.future.vote.backend.util.UID;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Data
@MappedEntity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Vote {
    // Generated vote unique id that identifies this vote action
    @Id
    @NonNull UID voteUid = new UID();
    // references the poll
    @NonNull Long pollId;
    // user that performs this voting action
    @NonNull String voterId;

    @DateCreated
    @TypeDef(type = DataType.TIMESTAMP)
    @NonNull Instant timestamp;

    // The Vote itself
    @TypeDef(type = DataType.JSON)
    @NonNull List<QuestionAnswer> answers;

    @TypeDef(type = DataType.JSON)
    VotingFacts facts;

    // previous vote in case the user has changed his mind and wants to update their decision
    UID updatedVoteUid;

}
