package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.Participant;
import digital.future.vote.backend.domain.ParticipantList;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.GenericRepository;


@JdbcRepository(dialect = Dialect.POSTGRES)
public interface ParticipantRepo extends CrudRepository<ParticipantList, String> {
    Iterable<String> findAllParticipantLists();
    void addParticipantList(String listName);
    void deleteParticipantList(String listName);

    Iterable<Participant> findParticipantsByListName(String listName);
    void addParticipantToList(String listName, Participant participant);
    void removeParticipantFromList(String listName, Participant participant);
}
