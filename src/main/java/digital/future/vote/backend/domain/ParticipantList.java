package digital.future.vote.backend.domain;

import java.util.List;
//TODO: pagination for participants
public class ParticipantList {
    String listName;
    Long ListId;
    Iterable<Participant> participants;
}
