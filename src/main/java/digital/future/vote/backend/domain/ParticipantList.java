package digital.future.vote.backend.domain;

import lombok.Data;
import lombok.NonNull;

//TODO: pagination for participants
@Data
public class ParticipantList {
    @NonNull String listName;
    Long ListId;
    Iterable<Participant> participants;
}
