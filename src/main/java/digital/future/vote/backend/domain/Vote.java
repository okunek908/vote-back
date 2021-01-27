package digital.future.vote.backend.domain;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@MappedEntity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Vote {
    // Generated vote unique id that identifies this vote action
    @Id
    @NonNull VoteId voteUid = new VoteId();
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
    VoteId updatedVoteUid;

}
